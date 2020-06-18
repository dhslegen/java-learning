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
 * @since 2020-06-12
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class HealthCareMedicineDirectory implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 物理主键
     */
    @TableId(value = "pk_no", type = IdType.AUTO)
    private Integer pkNo;

    /**
     * 药品表物理主键
     */
    private Integer medicinePkNo;

    /**
     * 医保目录药品编号
     */
    private String medicineCode;

    /**
     * 医保地区（数据参考医保地区表中的数据）
     */
    private String healthCareArea;

    /**
     * 医保版本（参考医保版本表中的数据）
     */
    private String healthCareVersion;

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
     * 规格（例如：0.27g/片）
     */
    private String specification;

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

    /**
     * 是否有效（Y-有效；N-无效）
     */
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


}
