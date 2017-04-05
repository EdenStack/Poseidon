package com.tneciv.poseidon.common;

import com.github.pagehelper.PageInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class PageVo<E> implements Serializable {
    private int pageNumber;
    private int pageSize;
    private long pageTotal;
    private long recordTotal;
    private boolean succ = true;
    private List<E> objects;

    public PageVo(PageInfo pageInfo, List<E> objects) {
        
        this.pageNumber = pageInfo.getPageNum();
        this.pageSize = pageInfo.getPageSize();
        this.recordTotal = pageInfo.getTotal();
        this.objects = objects;
        if (pageSize == 0) {
            this.pageNumber = 1;
            this.pageTotal = 1;
        } else {
            this.pageTotal = (long) ((int) Math.ceil((double) recordTotal
                    / Double.parseDouble(String.valueOf(pageSize))));
        }

    }

}
