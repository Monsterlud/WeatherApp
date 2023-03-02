package com.dmonsalud.ui.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0007H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/dmonsalud/ui/ui/WeatherListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/dmonsalud/ui/ui/WeatherListAdapter$WeatherItemViewHolder;", "fiveDayWeatherResult", "Lcom/dmonsalud/data/datasource/room/FiveDayWeatherResult;", "(Lcom/dmonsalud/data/datasource/room/FiveDayWeatherResult;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "WeatherItemViewHolder", "ui_debug"})
public final class WeatherListAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.dmonsalud.ui.ui.WeatherListAdapter.WeatherItemViewHolder> {
    private final com.dmonsalud.data.datasource.room.FiveDayWeatherResult fiveDayWeatherResult = null;
    
    public WeatherListAdapter(@org.jetbrains.annotations.NotNull()
    com.dmonsalud.data.datasource.room.FiveDayWeatherResult fiveDayWeatherResult) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.dmonsalud.ui.ui.WeatherListAdapter.WeatherItemViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.dmonsalud.ui.ui.WeatherListAdapter.WeatherItemViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/dmonsalud/ui/ui/WeatherListAdapter$WeatherItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/dmonsalud/ui/databinding/ItemListWeatherBinding;", "(Lcom/dmonsalud/ui/databinding/ItemListWeatherBinding;)V", "getBinding", "()Lcom/dmonsalud/ui/databinding/ItemListWeatherBinding;", "ui_debug"})
    public static final class WeatherItemViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.dmonsalud.ui.databinding.ItemListWeatherBinding binding = null;
        
        public WeatherItemViewHolder(@org.jetbrains.annotations.NotNull()
        com.dmonsalud.ui.databinding.ItemListWeatherBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.dmonsalud.ui.databinding.ItemListWeatherBinding getBinding() {
            return null;
        }
    }
}