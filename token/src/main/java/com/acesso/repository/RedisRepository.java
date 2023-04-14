package com.acesso.repository;

import io.quarkus.redis.datasource.ReactiveRedisDataSource;
import io.quarkus.redis.datasource.RedisDataSource;
import io.quarkus.redis.datasource.keys.ReactiveKeyCommands;
import io.quarkus.redis.datasource.value.ValueCommands;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RedisRepository {

    private ReactiveKeyCommands<String> keyCommands;
    private ValueCommands<String, String> countCommands;

    public RedisRepository(RedisDataSource ds, ReactiveRedisDataSource reactive) {
        countCommands = ds.value(String.class);
        keyCommands = reactive.key();

    }


    public ReactiveKeyCommands<String> getKeyCommands() {
        return keyCommands;
    }

    public void setKeyCommands(ReactiveKeyCommands<String> keyCommands) {
        this.keyCommands = keyCommands;
    }

    public ValueCommands<String, String> getCountCommands() {
        return countCommands;
    }

    public void setCountCommands(ValueCommands<String, String> countCommands) {
        this.countCommands = countCommands;
    }
}
