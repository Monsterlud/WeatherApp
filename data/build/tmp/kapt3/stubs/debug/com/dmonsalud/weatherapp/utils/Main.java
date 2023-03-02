package com.dmonsalud.weatherapp.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b)\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\rJ\t\u0010$\u001a\u00020\u0003H\u00c6\u0003J\t\u0010%\u001a\u00020\u0005H\u00c6\u0003J\t\u0010&\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\'\u001a\u00020\u0005H\u00c6\u0003J\t\u0010(\u001a\u00020\u0005H\u00c6\u0003J\t\u0010)\u001a\u00020\u0003H\u00c6\u0003J\t\u0010*\u001a\u00020\u0003H\u00c6\u0003J\t\u0010+\u001a\u00020\u0003H\u00c6\u0003J\t\u0010,\u001a\u00020\u0003H\u00c6\u0003Jc\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00101\u001a\u00020\u0005H\u00d6\u0001J\t\u00102\u001a\u000203H\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000f\"\u0004\b\u001f\u0010\u0011R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u000f\"\u0004\b!\u0010\u0011R\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u000f\"\u0004\b#\u0010\u0011\u00a8\u00064"}, d2 = {"Lcom/dmonsalud/weatherapp/utils/Main;", "", "feels_like", "", "grnd_level", "", "humidity", "pressure", "sea_level", "temp", "temp_kf", "temp_max", "temp_min", "(DIIIIDDDD)V", "getFeels_like", "()D", "setFeels_like", "(D)V", "getGrnd_level", "()I", "setGrnd_level", "(I)V", "getHumidity", "setHumidity", "getPressure", "setPressure", "getSea_level", "setSea_level", "getTemp", "setTemp", "getTemp_kf", "setTemp_kf", "getTemp_max", "setTemp_max", "getTemp_min", "setTemp_min", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "", "data_debug"})
public final class Main {
    private double feels_like;
    private int grnd_level;
    private int humidity;
    private int pressure;
    private int sea_level;
    private double temp;
    private double temp_kf;
    private double temp_max;
    private double temp_min;
    
    @org.jetbrains.annotations.NotNull()
    public final com.dmonsalud.weatherapp.utils.Main copy(double feels_like, int grnd_level, int humidity, int pressure, int sea_level, double temp, double temp_kf, double temp_max, double temp_min) {
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
    
    public Main(double feels_like, int grnd_level, int humidity, int pressure, int sea_level, double temp, double temp_kf, double temp_max, double temp_min) {
        super();
    }
    
    public final double component1() {
        return 0.0;
    }
    
    public final double getFeels_like() {
        return 0.0;
    }
    
    public final void setFeels_like(double p0) {
    }
    
    public final int component2() {
        return 0;
    }
    
    public final int getGrnd_level() {
        return 0;
    }
    
    public final void setGrnd_level(int p0) {
    }
    
    public final int component3() {
        return 0;
    }
    
    public final int getHumidity() {
        return 0;
    }
    
    public final void setHumidity(int p0) {
    }
    
    public final int component4() {
        return 0;
    }
    
    public final int getPressure() {
        return 0;
    }
    
    public final void setPressure(int p0) {
    }
    
    public final int component5() {
        return 0;
    }
    
    public final int getSea_level() {
        return 0;
    }
    
    public final void setSea_level(int p0) {
    }
    
    public final double component6() {
        return 0.0;
    }
    
    public final double getTemp() {
        return 0.0;
    }
    
    public final void setTemp(double p0) {
    }
    
    public final double component7() {
        return 0.0;
    }
    
    public final double getTemp_kf() {
        return 0.0;
    }
    
    public final void setTemp_kf(double p0) {
    }
    
    public final double component8() {
        return 0.0;
    }
    
    public final double getTemp_max() {
        return 0.0;
    }
    
    public final void setTemp_max(double p0) {
    }
    
    public final double component9() {
        return 0.0;
    }
    
    public final double getTemp_min() {
        return 0.0;
    }
    
    public final void setTemp_min(double p0) {
    }
}