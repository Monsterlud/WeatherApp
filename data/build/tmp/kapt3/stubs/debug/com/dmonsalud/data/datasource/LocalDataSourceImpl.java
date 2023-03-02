package com.dmonsalud.data.datasource;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0014\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nH\u0016J\u001b\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lcom/dmonsalud/data/datasource/LocalDataSourceImpl;", "Lcom/dmonsalud/data/LocalDataSource;", "weatherDAO", "Lcom/dmonsalud/data/datasource/room/WeatherDAO;", "gson", "Lcom/google/gson/Gson;", "mapper", "Lcom/dmonsalud/data/datasource/utils/EntityMappers;", "(Lcom/dmonsalud/data/datasource/room/WeatherDAO;Lcom/google/gson/Gson;Lcom/dmonsalud/data/datasource/utils/EntityMappers;)V", "getWeatherForecast", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/dmonsalud/data/datasource/room/WeatherEntity;", "saveWeatherForecast", "", "value", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_debug"})
public final class LocalDataSourceImpl implements com.dmonsalud.data.LocalDataSource {
    private final com.dmonsalud.data.datasource.room.WeatherDAO weatherDAO = null;
    private final com.google.gson.Gson gson = null;
    private final com.dmonsalud.data.datasource.utils.EntityMappers mapper = null;
    
    public LocalDataSourceImpl(@org.jetbrains.annotations.NotNull()
    com.dmonsalud.data.datasource.room.WeatherDAO weatherDAO, @org.jetbrains.annotations.NotNull()
    com.google.gson.Gson gson, @org.jetbrains.annotations.NotNull()
    com.dmonsalud.data.datasource.utils.EntityMappers mapper) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object saveWeatherForecast(@org.jetbrains.annotations.Nullable()
    java.lang.String value, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.dmonsalud.data.datasource.room.WeatherEntity>> getWeatherForecast() {
        return null;
    }
}