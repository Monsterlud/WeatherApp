package com.dmonsalud.data.datasource.room;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0014\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b0\nH\'\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lcom/dmonsalud/data/datasource/room/WeatherDAO;", "", "addWeatherResponseToRoom", "", "entity", "Lcom/dmonsalud/data/datasource/room/WeatherEntity;", "(Lcom/dmonsalud/data/datasource/room/WeatherEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearDatabase", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getWeatherResponseFromRoom", "Lkotlinx/coroutines/flow/Flow;", "", "data_debug"})
public abstract interface WeatherDAO {
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert(onConflict = 5)
    public abstract java.lang.Object addWeatherResponseToRoom(@org.jetbrains.annotations.NotNull()
    com.dmonsalud.data.datasource.room.WeatherEntity entity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM weather_table ORDER BY id ASC")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.dmonsalud.data.datasource.room.WeatherEntity>> getWeatherResponseFromRoom();
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "DELETE FROM weather_table")
    public abstract java.lang.Object clearDatabase(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
}