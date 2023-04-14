package com.acesso.repositories;

import com.acesso.models.*;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ClientRepository implements PanacheRepository<Client> {

    @Inject
    EntityManager em = getEntityManager();

    public Client findByExternalId(String externalId) {
        Optional<Client> client = find("external_id", externalId).firstResultOptional();


        if (client.isPresent()) {
            return (client.get());
        } else {
            throw new NotFoundException("Client não encontrado");
        }
    }

    public UserInfo getSimplifiedUserByUserId(String userId) {
        String query = "SELECT\n" +
                "    u.user_id, name, u.client_id, email, image, client.password, client.deprecated_password,\n" +
                "    client.last_password_update, user_validation_level,\n" +
                "    tf.enabled as two_factor_enabled, tf.activation_date as two_factor_activation_date,\n" +
                "    exists (\n" +
                "            select role_id\n" +
                "              from security.roles_assignments assignments\n" +
                "                      join security.roles roles on roles.id = role_id and two_factor_required=true\n" +
                "                      where assignments.client_id = u.client_id\n" +
                "    ) as two_factor_required,\n" +
                "    br.social_name\n" +
                "    FROM security.users u\n" +
                "    INNER JOIN security.clients client on client.id = client_id\n" +
                "    INNER JOIN security.two_factor tf on tf.client_id = u.client_id\n" +
                "    LEFT JOIN userdetails.brazilian_personal br on br.user_id = :userId \n" +
                "    where u.user_id= :userId ";

        List result = em.createNativeQuery(query, SimplifiedUserResult.class)
                .setParameter("userId", userId)
                .getResultList();

        SimplifiedUserResult userResult = (SimplifiedUserResult) result.get(0);

        String name = userResult.getSocialName() == null ? userResult.getName() : userResult.getSocialName();

        return new UserInfo(userResult.getUserId(), name, userResult.getEmail(), userResult.getImage(),
                        new UserAccountInfo(false, userResult.getDeprecatedPassword(),
                                !(userResult.getPassword().isEmpty()), userResult.getLastPasswordUpdate().toLocalDateTime(),
                                userResult.getLastPasswordUpdate().toLocalDateTime().plusDays(1000), userResult.getTwoFactorEnabled(),
                                userResult.getTwoFactorRequired(), userResult.getTwoFactorActivationDate().toLocalDateTime()));


    }

}
