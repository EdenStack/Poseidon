package com.tneciv.poseidon.common;

import com.github.pagehelper.PageInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class PageVo<E> implements Serializable {

    private static final long serialVersionUID = -4303488258066205507L;
    
    private int pageNumber;
    private int pageSize;
    private long pageTotal;
    private long recordTotal;
    private boolean succ = true;
    private List<E> content;

    public PageVo(PageInfo pageInfo) {

        this.pageNumber = pageInfo.getPageNum();
        this.pageSize = pageInfo.getPageSize();
        this.recordTotal = pageInfo.getTotal();
        this.content = pageInfo.getList();
        if (pageSize == 0) {
            this.pageNumber = 1;
            this.pageTotal = 1;
            try {
                this.pageSize = Math.toIntExact(this.recordTotal);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            this.pageTotal = (long) ((int) Math.ceil((double) recordTotal
                    / Double.parseDouble(String.valueOf(pageSize))));
        }

    }

    public PageVo(PageInfo pageInfo, List<E> list) {
        this(pageInfo);
        this.content = list;
    }

}
