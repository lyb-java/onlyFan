package com.zm.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author : liyangbin
 * @date :  2020-5-15
 */
public class PageViewDto <T> implements Serializable {
    /**
     * 分页页面索引;从1开始 默认为1
     */
    @NotNull(message = "分页参数pageIndex不能为空")
    private Integer pageIndex;

    /**
     *分页页面显示记录条数; 默认为10
     */

    @NotNull(message = "分页参数pageSize不能为空")
    private Integer pageSize;
    /**
     * 查询实体对象
     */
    @Valid
    @NotNull(message = "查询条件不能为空")
    private T condition;

    public Integer getPageIndex() {
        return pageIndex == null ? Integer.valueOf(1): pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize == null ? Integer.valueOf(10) : pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public T getCondition() {
        return condition;
    }

    public void setCondition(T condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "com.zm.dto.PageViewDto{" +
                "pageIndex=" + pageIndex +
                ", pageSize=" + pageSize +
                ", condition=" + condition +
                '}';
    }
}
