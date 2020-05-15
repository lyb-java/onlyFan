package com.zm.dto;

import java.io.Serializable;

/**
 * @author : liyangbin
 * @date :  2020-5-15
 */
public class PageViewRspDto<T> implements Serializable {

    /**
     * 记录条数
     */
    private long totalCount;
    /**
     * 分页对象
     */
    private T pageData;

    public PageViewRspDto() {

    }

    /**
     * 分页响应封装对象构造函数
     * @param pageData 数据集合
     * @param totalCount 总记录条数
     */
    public PageViewRspDto(T pageData, long totalCount) {
        this.pageData = pageData;
        this.totalCount = totalCount;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public T getPageData() {
        return pageData;
    }

    public void setPageData(T pageData) {
        this.pageData = pageData;
    }

    @Override
    public String toString() {
        return "PageViewRspDto{" +
                "totalCount=" + totalCount +
                ", pageData=" + pageData +
                '}';
    }
}
