package javaStudy.tools.mybatis.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author dhslegen
 * @since 2020-06-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class IncludedPayment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 物理主键
     */
    private Integer directoryPkNo;

    /**
     * 医保目录分类（01-西药；02-中成药；03-中药饮片；04-协议期内谈判西药；05-协议期内谈判中成药）
     */
    private String directoryType;

    /**
     * 医保目录药品编号
     */
    private String directoryMedicineCode;

    /**
     * 药品名称
     */
    private String directoryMedicineName;

    /**
     * 剂型（参考医保药品剂型表数据）
     */
    private String directoryForm;

    /**
     * pk_no
     */
    private Integer pkNo;

    /**
     * 医保药品目录表物理主键
     */
    private Integer medicineDirectoryPkNo;


}
