package com.i2finance.bean;


import java.sql.Date;

/**
 * @author 白昊天
 * @date 2018/1/21
 **/
public class WinLog implements MyModule{

    private int id;
    private int winnerId;
    private String winDate;
    private String winnerName;

    public String getWinnerName() {
        return winnerName;
    }

    public void setWinnerName(String winnerName) {
        this.winnerName = winnerName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWinnerId() {
        return winnerId;
    }

    public void setWinnerId(int winnerId) {
        this.winnerId = winnerId;
    }

    public String getWinDate() {
        return winDate;
    }

    public void setWinDate(String winningDate) {
        this.winDate = winningDate;
    }


}
