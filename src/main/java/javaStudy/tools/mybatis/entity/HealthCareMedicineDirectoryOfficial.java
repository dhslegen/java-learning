package javaStudy.tools.mybatis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author dhslegen
 * @since 2020-06-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class HealthCareMedicineDirectoryOfficial implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 物理主键
     */
    @TableId(value = "pk_no", type = IdType.AUTO)
    private Integer pkNo;

    /**
     * 医保目录药品编号
     */
    private String medicineCode;

    /**
     * 药品类别一级分类（参考医保药品类别表数据）
     */
    private String medicineCategoryLevel1;

    /**
     * 药品类别二级分类（参考医保药品类别表数据）
     */
    private String medicineCategoryLevel2;

    /**
     * 药品类别三级分类（参考医保药品类别表数据）
     */
    private String medicineCategoryLevel3;

    /**
     * 药品类别四级分类（参考医保药品类别表数据）
     */
    private String medicineCategoryLevel4;

    /**
     * 药品名称
     */
    private String medicineName;

    /**
     * 剂型（参考医保药品剂型表数据）
     */
    private String form;

    /**
     * 医保类别（01-甲类；02-乙类）
     */
    private String healthCareCategory;

    /**
     * 医保目录分类（01-西药；02-中成药；03-中药饮片；04-协议期内谈判西药；05-协议期内谈判中成药）
     */
    private String directoryType;

    /**
     * 备注（说明药品医保支付范围）
     */
    private String comment;

}
