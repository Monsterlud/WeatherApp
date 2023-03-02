package com.dmonsalud.weatherapp.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b3\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u00a2\u0006\u0002\u0010\u0016J\t\u0010=\u001a\u00020\u0003H\u00c6\u0003J\t\u0010>\u001a\u00020\u0015H\u00c6\u0003J\t\u0010?\u001a\u00020\u0005H\u00c6\u0003J\t\u0010@\u001a\u00020\u0007H\u00c6\u0003J\t\u0010A\u001a\u00020\tH\u00c6\u0003J\t\u0010B\u001a\u00020\u000bH\u00c6\u0003J\t\u0010C\u001a\u00020\rH\u00c6\u0003J\t\u0010D\u001a\u00020\u000fH\u00c6\u0003J\t\u0010E\u001a\u00020\u0005H\u00c6\u0003J\u000f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u00c6\u0003Js\u0010G\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00052\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u00c6\u0001J\u0013\u0010H\u001a\u00020I2\b\u0010J\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010K\u001a\u00020\u0005H\u00d6\u0001J\t\u0010L\u001a\u00020\u0007H\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010(\"\u0004\b)\u0010*R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001c\"\u0004\b4\u0010\u001eR \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<\u00a8\u0006M"}, d2 = {"Lcom/dmonsalud/weatherapp/utils/OpenWeatherApiResponse;", "", "clouds", "Lcom/dmonsalud/weatherapp/utils/Clouds;", "dt", "", "dt_txt", "", "main", "Lcom/dmonsalud/weatherapp/utils/Main;", "pop", "", "rain", "Lcom/dmonsalud/weatherapp/utils/Rain;", "sys", "Lcom/dmonsalud/weatherapp/utils/Sys;", "visibility", "weather", "", "Lcom/dmonsalud/weatherapp/utils/Weather;", "wind", "Lcom/dmonsalud/weatherapp/utils/Wind;", "(Lcom/dmonsalud/weatherapp/utils/Clouds;ILjava/lang/String;Lcom/dmonsalud/weatherapp/utils/Main;DLcom/dmonsalud/weatherapp/utils/Rain;Lcom/dmonsalud/weatherapp/utils/Sys;ILjava/util/List;Lcom/dmonsalud/weatherapp/utils/Wind;)V", "getClouds", "()Lcom/dmonsalud/weatherapp/utils/Clouds;", "setClouds", "(Lcom/dmonsalud/weatherapp/utils/Clouds;)V", "getDt", "()I", "setDt", "(I)V", "getDt_txt", "()Ljava/lang/String;", "setDt_txt", "(Ljava/lang/String;)V", "getMain", "()Lcom/dmonsalud/weatherapp/utils/Main;", "setMain", "(Lcom/dmonsalud/weatherapp/utils/Main;)V", "getPop", "()D", "setPop", "(D)V", "getRain", "()Lcom/dmonsalud/weatherapp/utils/Rain;", "setRain", "(Lcom/dmonsalud/weatherapp/utils/Rain;)V", "getSys", "()Lcom/dmonsalud/weatherapp/utils/Sys;", "setSys", "(Lcom/dmonsalud/weatherapp/utils/Sys;)V", "getVisibility", "setVisibility", "getWeather", "()Ljava/util/List;", "setWeather", "(Ljava/util/List;)V", "getWind", "()Lcom/dmonsalud/weatherapp/utils/Wind;", "setWind", "(Lcom/dmonsalud/weatherapp/utils/Wind;)V", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "data_debug"})
public final class OpenWeatherApiResponse {
    @org.jetbrains.annotations.NotNull()
    private com.dmonsalud.weatherapp.utils.Clouds clouds;
    private int dt;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String dt_txt;
    @org.jetbrains.annotations.NotNull()
    private com.dmonsalud.weatherapp.utils.Main main;
    private double pop;
    @org.jetbrains.annotations.NotNull()
    private com.dmonsalud.weatherapp.utils.Rain rain;
    @org.jetbrains.annotations.NotNull()
    private com.dmonsalud.weatherapp.utils.Sys sys;
    private int visibility;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.dmonsalud.weatherapp.utils.Weather> weather;
    @org.jetbrains.annotations.NotNull()
    private com.dmonsalud.weatherapp.utils.Wind wind;
    
    @org.jetbrains.annotations.NotNull()
    public final com.dmonsalud.weatherapp.utils.OpenWeatherApiResponse copy(@org.jetbrains.annotations.NotNull()
    com.dmonsalud.weatherapp.utils.Clouds clouds, int dt, @org.jetbrains.annotations.NotNull()
    java.lang.String dt_txt, @org.jetbrains.annotations.NotNull()
    com.dmonsalud.weatherapp.utils.Main main, double pop, @org.jetbrains.annotations.NotNull()
    com.dmonsalud.weatherapp.utils.Rain rain, @org.jetbrains.annotations.NotNull()
    com.dmonsalud.weatherapp.utils.Sys sys, int visibility, @org.jetbrains.annotations.NotNull()
    java.util.List<com.dmonsalud.weatherapp.utils.Weather> weather, @org.jetbrains.annotations.NotNull()
    com.dmonsalud.weatherapp.utils.Wind wind) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public OpenWeatherApiResponse(@org.jetbrains.annotations.NotNull()
    com.dmonsalud.weatherapp.utils.Clouds clouds, int dt, @org.jetbrains.annotations.NotNull()
    java.lang.String dt_txt, @org.jetbrains.annotations.NotNull()
    com.dmonsalud.weatherapp.utils.Main main, double pop, @org.jetbrains.annotations.NotNull()
    com.dmonsalud.weatherapp.utils.Rain rain, @org.jetbrains.annotations.NotNull()
    com.dmonsalud.weatherapp.utils.Sys sys, int visibility, @org.jetbrains.annotations.NotNull()
    java.util.List<com.dmonsalud.weatherapp.utils.Weather> weather, @org.jetbrains.annotations.NotNull()
    com.dmonsalud.weatherapp.utils.Wind wind) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.dmonsalud.weatherapp.utils.Clouds component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.dmonsalud.weatherapp.utils.Clouds getClouds() {
        return null;
    }
    
    public final void setClouds(@org.jetbrains.annotations.NotNull()
    com.dmonsalud.weatherapp.utils.Clouds p0) {
    }
    
    public final int component2() {
        return 0;
    }
    
    public final int getDt() {
        return 0;
    }
    
    public final void setDt(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDt_txt() {
        return null;
    }
    
    public final void setDt_txt(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.dmonsalud.weatherapp.utils.Main component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.dmonsalud.weatherapp.utils.Main getMain() {
        return null;
    }
    
    public final void setMain(@org.jetbrains.annotations.NotNull()
    com.dmonsalud.weatherapp.utils.Main p0) {
    }
    
    public final double component5() {
        return 0.0;
    }
    
    public final double getPop() {
        return 0.0;
    }
    
    public final void setPop(double p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.dmonsalud.weatherapp.utils.Rain component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.dmonsalud.weatherapp.utils.Rain getRain() {
        return null;
    }
    
    public final void setRain(@org.jetbrains.annotations.NotNull()
    com.dmonsalud.weatherapp.utils.Rain p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.dmonsalud.weatherapp.utils.Sys component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.dmonsalud.weatherapp.utils.Sys getSys() {
        return null;
    }
    
    public final void setSys(@org.jetbrains.annotations.NotNull()
    com.dmonsalud.weatherapp.utils.Sys p0) {
    }
    
    public final int component8() {
        return 0;
    }
    
    public final int getVisibility() {
        return 0;
    }
    
    public final void setVisibility(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.dmonsalud.weatherapp.utils.Weather> component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.dmonsalud.weatherapp.utils.Weather> getWeather() {
        return null;
    }
    
    public final void setWeather(@org.jetbrains.annotations.NotNull()
    java.util.List<com.dmonsalud.weatherapp.utils.Weather> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.dmonsalud.weatherapp.utils.Wind component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.dmonsalud.weatherapp.utils.Wind getWind() {
        return null;
    }
    
    public final void setWind(@org.jetbrains.annotations.NotNull()
    com.dmonsalud.weatherapp.utils.Wind p0) {
    }
}