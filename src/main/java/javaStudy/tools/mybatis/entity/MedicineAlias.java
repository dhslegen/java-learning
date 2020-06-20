package javaStudy.tools.mybatis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author dhslegen
 * @since 2020-06-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MedicineAlias implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 物理主键
     */
    @TableId(value = "pk_no", type = IdType.AUTO)
    private Integer pkNo;

    /**
     * 药品通用名称表物理主键
     */
    private Integer commonNamePkNo;

    /**
     * 药品别名
     */
    private String medicineAliasName;

    private String isValid;

    /**
     * 创建人
     */
    private String createdUser;

    /**
     * 修改人
     */
    private String updatedUser;

    /**
     * 创建日期
     */
    private LocalDateTime createdDate;

    /**
     * 更新日期
     */
    private LocalDateTime updatedDate;

    /**
     * 是否已拆分关键词
     */
    private String isSplit;

    /**
     * 是否已生成音形码
     */
    private String isEncoded;

    /**
     * 是否是通用名称的通用别名(Y : 通用别名, N : 普通别名)
     */
    private String isCommon;


}
