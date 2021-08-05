package com.lll.android.bean;

import java.util.List;

public class MotoBean {

    private int code;
    private List<Datam> data;

    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Datam> getData() {
        return data;
    }

    public void setData(List<Datam> data) {
        this.data = data;
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public static class Datam {
        private int brandId;
        private String brandName;
        private int browseCount;
        private String discount;
        private int goodId;
        private String goodName;
        private String goodPic;
        private String goodPrice;
        private int grade;
        private int gradeCount;
        private String maxPrice;
        private String minPrice;
        private int queryPriceCount;
        private int rankChange;
        private int saleStatus;

        public int getBrandId() {
            return brandId;
        }

        public void setBrandId(int brandId) {
            this.brandId = brandId;
        }

        public String getBrandName() {
            return brandName;
        }

        public void setBrandName(String brandName) {
            this.brandName = brandName;
        }

        public int getBrowseCount() {
            return browseCount;
        }

        public void setBrowseCount(int browseCount) {
            this.browseCount = browseCount;
        }

        public String getDiscount() {
            return discount;
        }

        public void setDiscount(String discount) {
            this.discount = discount;
        }

        public int getGoodId() {
            return goodId;
        }

        public void setGoodId(int goodId) {
            this.goodId = goodId;
        }

        public String getGoodName() {
            return goodName;
        }

        public void setGoodName(String goodName) {
            this.goodName = goodName;
        }

        public String getGoodPic() {
            return goodPic;
        }

        public void setGoodPic(String goodPic) {
            this.goodPic = goodPic;
        }

        public String getGoodPrice() {
            return goodPrice;
        }

        public void setGoodPrice(String goodPrice) {
            this.goodPrice = goodPrice;
        }

        public int getGrade() {
            return grade;
        }

        public void setGrade(int grade) {
            this.grade = grade;
        }

        public int getGradeCount() {
            return gradeCount;
        }

        public void setGradeCount(int gradeCount) {
            this.gradeCount = gradeCount;
        }

        public String getMaxPrice() {
            return maxPrice;
        }

        public void setMaxPrice(String maxPrice) {
            this.maxPrice = maxPrice;
        }

        public String getMinPrice() {
            return minPrice;
        }

        public void setMinPrice(String minPrice) {
            this.minPrice = minPrice;
        }

        public int getQueryPriceCount() {
            return queryPriceCount;
        }

        public void setQueryPriceCount(int queryPriceCount) {
            this.queryPriceCount = queryPriceCount;
        }

        public int getRankChange() {
            return rankChange;
        }

        public void setRankChange(int rankChange) {
            this.rankChange = rankChange;
        }

        public int getSaleStatus() {
            return saleStatus;
        }

        public void setSaleStatus(int saleStatus) {
            this.saleStatus = saleStatus;
        }
    }
}
