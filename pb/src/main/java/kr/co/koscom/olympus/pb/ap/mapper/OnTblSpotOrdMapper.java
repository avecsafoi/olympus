package kr.co.koscom.olympus.pb.ap.mapper;

import kr.co.koscom.olympus.pb.ab.db.mapper.PBMapper;
import kr.co.koscom.olympus.pb.ab.db.page.PBCPage;
import kr.co.koscom.olympus.pb.ab.db.page.PBNPage;
import kr.co.koscom.olympus.pb.ap.entity.OnTblSpotOrd;
import kr.co.koscom.olympus.pb.aps.on.bms.SPOT_ORD_TRX_SP_ST;
import kr.co.koscom.olympus.pb.test.pb.io.OrdQi;
import kr.co.koscom.olympus.pb.test.pb.io.OrdQiWithCPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 映射层。
 *
 * @author KOSCOM
 * @since 2025-08-12
 */
@Mapper
public interface OnTblSpotOrdMapper extends PBMapper<OnTblSpotOrd> {

    void ON_FN_SPOT_ORD_MAIN(@Param("st") SPOT_ORD_TRX_SP_ST st);

    @Select("select * from on_tbl_spot_ord where ord_dt >= #{ordDt} LIMIT #{offset}, #{limit}")
    List<OnTblSpotOrd> page01(OrdQi qi);

    @Select("select * from on_tbl_spot_ord where ord_dt >= #{qi.ordDt} LIMIT #{qi.offset}, #{qi.limit}")
    List<OnTblSpotOrd> page02(@Param("qi") OrdQi qi);

    @Select("select * from on_tbl_spot_ord where ord_dt >= #{ordDt}")
    List<OnTblSpotOrd> page52(OrdQiWithCPage qi);

    @Select("select * from on_tbl_spot_ord where ord_dt >= #{qi.ordDt}")
    List<OnTblSpotOrd> page53(@Param("qi") OrdQiWithCPage qi);

}
