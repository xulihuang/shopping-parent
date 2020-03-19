package com.shopping.universal;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: xlh
 * @Description: 统一返回数据
 * @Date: Create in 17:05 2020/3/17 0017
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@JsonSerialize(include = JsonSerialize.Inclusion.ALWAYS)
public class RestResponse implements Serializable {

    private Integer total;

    private List<?> rows;

    public static RestResponse result(Integer integer, List<?> rows) {
        return new RestResponse(integer, rows);
    }
}
