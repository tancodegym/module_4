package com.codegym.model;

public class History {
    private boolean denGan;
    private boolean tiepXuc;

    public History() {
    }

    public History(boolean denGan, boolean tiepXuc) {
        this.denGan = denGan;
        this.tiepXuc = tiepXuc;
    }

    public boolean isDenGan() {
        return denGan;
    }

    public void setDenGan(boolean denGan) {
        this.denGan = denGan;
    }

    public boolean isTiepXuc() {
        return tiepXuc;
    }

    public void setTiepXuc(boolean tiepXuc) {
        this.tiepXuc = tiepXuc;
    }
}
