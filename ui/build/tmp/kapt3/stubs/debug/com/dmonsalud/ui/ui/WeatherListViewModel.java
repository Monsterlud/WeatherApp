package com.dmonsalud.ui.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0014\u001a\u00020\u0015J!\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001aR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001b"}, d2 = {"Lcom/dmonsalud/ui/ui/WeatherListViewModel;", "Landroidx/lifecycle/ViewModel;", "weatherListRepository", "Lcom/dmonsalud/data/WeatherListRepository;", "networkUtils", "Lcom/dmonsalud/data/datasource/utils/NetworkUtils;", "(Lcom/dmonsalud/data/WeatherListRepository;Lcom/dmonsalud/data/datasource/utils/NetworkUtils;)V", "_weatherForecast", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/dmonsalud/data/datasource/room/FiveDayWeatherResult;", "location", "", "getLocation", "()Ljava/lang/String;", "setLocation", "(Ljava/lang/String;)V", "weatherForecast", "Lkotlinx/coroutines/flow/StateFlow;", "getWeatherForecast", "()Lkotlinx/coroutines/flow/StateFlow;", "initialize", "", "saveFiveDayWeatherForecast", "zipCode", "connectivityManager", "Landroid/net/ConnectivityManager;", "(Ljava/lang/String;Landroid/net/ConnectivityManager;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui_debug"})
public final class WeatherListViewModel extends androidx.lifecycle.ViewModel {
    private final com.dmonsalud.data.WeatherListRepository weatherListRepository = null;
    private final com.dmonsalud.data.datasource.utils.NetworkUtils networkUtils = null;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String location;
    
    /**
     * State Flow For UI to use
     */
    private final kotlinx.coroutines.flow.MutableStateFlow<com.dmonsalud.data.datasource.room.FiveDayWeatherResult> _weatherForecast = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.dmonsalud.data.datasource.room.FiveDayWeatherResult> weatherForecast = null;
    
    public WeatherListViewModel(@org.jetbrains.annotations.NotNull()
    com.dmonsalud.data.WeatherListRepository weatherListRepository, @org.jetbrains.annotations.NotNull()
    com.dmonsalud.data.datasource.utils.NetworkUtils networkUtils) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getLocation() {
        return null;
    }
    
    public final void setLocation(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.dmonsalud.data.datasource.room.FiveDayWeatherResult> getWeatherForecast() {
        return null;
    }
    
    public final void initialize() {
    }
    
    /**
     * Save Five Day Weather Forecast
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveFiveDayWeatherForecast(@org.jetbrains.annotations.NotNull()
    java.lang.String zipCode, @org.jetbrains.annotations.NotNull()
    android.net.ConnectivityManager connectivityManager, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}