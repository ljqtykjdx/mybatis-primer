package com.imooc.mybatis.mapper;


import com.imooc.mybatis.model.Cwxx_txl;
import com.imooc.mybatis.model.Cwxx_wldw;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * Created by wff on 2020/5/1.
 */

@Repository
public interface CwxxTxlMapper {

    /**
     * 根据id查询单位信息
     *
     * @param dwId
     * @return
     */
    @Select("  select A.* ,B.F_DWMC f_SJMC , C.F_LXMC f_LXMC ,A.BMZD_BMID F_YSBH from  LSDWZD   A LEFT JOIN   LSDWZD  B   ON   A.F_SJDW =B.F_DWBH      " +
            " LEFT JOIN LSDWLX C  ON  A.F_DWLX =C.F_LXBH " +
            "   where A.F_DWBH= #{dwId} ")
    Cwxx_wldw getWldwToId(@Param("dwId") String dwId);


    /**
     * 根据id查询单位下用户信息
     * @param dwId
     * @return
     */
    @Select("SELECT * FROM (SELECT A.*,  ROW_NUMBER() OVER(Order by cast(f_id as int) ASC ) AS RN  FROM (  SELECT A.*  FROM PSTXL A     WHERE   1=1    AND F_BMID = '10001010CJGC'    ) A   )   SADA   order by (f_id+0) ")
    List<Cwxx_txl> getUserMsg(@Param("dwId") String dwId);

    /**
     * 根据id查询单位下处级以上用户信息
     * @param dwId
     * @return
     */
    @Select("select id from PSTXL p where F_BMID = #{f_dwbh} AND " +
            "(F_TXL1 LIKE '%经理%' or F_TXL1 Like '%处长%' or F_TXL1 like '%部长%' or F_txl1 like '%总会计师%'  " +
            "or F_TXL1 LIKE '%领导%'   or F_TXL1 LIKE '%总监%'  or F_TXL1 LIKE '%院长%'  or F_TXL1 LIKE '%书记%'  or F_TXL1 LIKE '%专家%'  ) "+
            "order by (f_id + 0)")
    List<String> selectIdList(@Param("dwId") String dwId);

}
