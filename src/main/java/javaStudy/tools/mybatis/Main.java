package javaStudy.tools.mybatis;

import javaStudy.tools.mybatis.entity.*;
import javaStudy.tools.mybatis.mapper.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        // 指定配置文件
        String resource = "javaStudy/tools/mybatis/mybatis-config.xml";
        // 读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 构建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        // HealthCareMedicineDirectoryOfficialMapper healthCareMedicineDirectoryOfficialMapper = sqlSession.getMapper(HealthCareMedicineDirectoryOfficialMapper.class);
        // List<Map<String, String>> mapList = healthCareMedicineDirectoryOfficialMapper.getForms();
        // HashMap<String, String> forms = new HashMap<>();
        // for (Map<String, String> stringStringMap : mapList) {
        //     forms.put(stringStringMap.get("form_name"), stringStringMap.get("form_code"));
        // }
        // List<HealthCareMedicineDirectoryOfficial> healthCareMedicineDirectoryOfficials = javaStudy.tools.excel解析.Main.parse("/Users/zhaowenhao/Documents/GitRepositories/document/普元公司/知识库/山东官方医保目录/西药部分修复.xlsx", forms);
        // List<HealthCareMedicineDirectoryOfficial> healthCareMedicineDirectoryOfficials1 = javaStudy.tools.excel解析.Main.parse1("/Users/zhaowenhao/Documents/GitRepositories/document/普元公司/知识库/山东官方医保目录/中成药部分.xlsx");
        // for (HealthCareMedicineDirectoryOfficial healthCareMedicineDirectoryOfficial : healthCareMedicineDirectoryOfficials) {
        //     healthCareMedicineDirectoryOfficialMapper.save(healthCareMedicineDirectoryOfficial);
        // }
        // for (HealthCareMedicineDirectoryOfficial healthCareMedicineDirectoryOfficial : healthCareMedicineDirectoryOfficials1) {
        //     healthCareMedicineDirectoryOfficialMapper.save(healthCareMedicineDirectoryOfficial);
        // }

        // 列举所有受影响的关联数据
        // IncludedPaymentMapper includedPaymentMapper = sqlSession.getMapper(IncludedPaymentMapper.class);
        // HealthCareMedicineDirectoryMapper healthCareMedicineDirectoryMapper = sqlSession.getMapper(HealthCareMedicineDirectoryMapper.class);
        // PaymentNewMapper paymentNewMapper = sqlSession.getMapper(PaymentNewMapper.class);
        // List<IncludedPayment> includedPayments = includedPaymentMapper.list();
        // for (IncludedPayment includedPayment : includedPayments) {
        //     // 找到同样的医保编码但是不是本身
        //     List<HealthCareMedicineDirectory> healthCareMedicineDirectories = healthCareMedicineDirectoryMapper.getByMedicineCodeAndForm(includedPayment.getDirectoryMedicineCode(), includedPayment.getDirectoryType(), includedPayment.getDirectoryForm());
        //     if (healthCareMedicineDirectories.size() > 0) {
        //         for (HealthCareMedicineDirectory healthCareMedicineDirectory : healthCareMedicineDirectories) {
        //             PaymentNew paymentNew = new PaymentNew();
        //             paymentNew.setPkNo(includedPayment.getPkNo());
        //             paymentNew.setMedicineDirectoryPkNo(includedPayment.getMedicineDirectoryPkNo());
        //             paymentNew.setNewMedicineDirectoryPkNo(healthCareMedicineDirectory.getPkNo());
        //             paymentNewMapper.add(paymentNew);
        //         }
        //     } else {
        //         PaymentNew paymentNew = new PaymentNew();
        //         paymentNew.setPkNo(includedPayment.getPkNo());
        //         paymentNew.setMedicineDirectoryPkNo(includedPayment.getMedicineDirectoryPkNo());
        //         paymentNew.setNewMedicineDirectoryPkNo(null);
        //         paymentNewMapper.add(paymentNew);
        //     }
        // }

        TestZwhDirectoryNeedAddMapper testZwhDirectoryNeedAddMapper = sqlSession.getMapper(TestZwhDirectoryNeedAddMapper.class);
        HealthCareMedicineDirectoryMapper healthCareMedicineDirectoryMapper = sqlSession.getMapper(HealthCareMedicineDirectoryMapper.class);
        HealthCareMedicinePaymentStandardMapper healthCareMedicinePaymentStandardMapper = sqlSession.getMapper(HealthCareMedicinePaymentStandardMapper.class);
        HealthCareMedicineMapMapper healthCareMedicineMapMapper = sqlSession.getMapper(HealthCareMedicineMapMapper.class);
        MedicineCommonNameMapper medicineCommonNameMapper = sqlSession.getMapper(MedicineCommonNameMapper.class);
        MedicineMapper medicineMapper = sqlSession.getMapper(MedicineMapper.class);
        MedicineAliasMapper medicineAliasMapper = sqlSession.getMapper(MedicineAliasMapper.class);

        // 获取需要新增的列表
        List<TestZwhDirectoryNeedAdd> testZwhDirectoryNeedAddList = testZwhDirectoryNeedAddMapper.list();
        // 遍历
        try {
            for (TestZwhDirectoryNeedAdd testZwhDirectoryNeedAdd : testZwhDirectoryNeedAddList) {
                // 查看是医保目录是否存在
                String directoryType = testZwhDirectoryNeedAdd.getDirectoryType();
                String paymentAreaCode = testZwhDirectoryNeedAdd.getPaymentAreaCode();
                String medicineName = testZwhDirectoryNeedAdd.getMedicineName();
                String healthCareCategory = testZwhDirectoryNeedAdd.getHealthCareCategory();
                String form = testZwhDirectoryNeedAdd.getForm();
                String cname = testZwhDirectoryNeedAdd.getCname();
                float paymentProportion = testZwhDirectoryNeedAdd.getPaymentProportion();
                Integer healthCareMedicineDirectoryPkNo = 0;
                if ("01".equals(directoryType)) {
                    // 西药
                    HealthCareMedicineDirectory healthCareMedicineDirectory = healthCareMedicineDirectoryMapper.getByMedicineNameAndForm(medicineName, form);
                    if (healthCareMedicineDirectory != null) {
                        // 存在则获得主键
                        healthCareMedicineDirectoryPkNo = healthCareMedicineDirectory.getPkNo();
                    } else {
                        // 不存在则新增并获取主键
                        HealthCareMedicineDirectory healthCareMedicineDirectory1 = new HealthCareMedicineDirectory();
                        String prefix = "mkbyb_";
                        String maxMedicineCode = healthCareMedicineDirectoryMapper.getMaxMedicineCode(prefix);
                        String medicineCode = maxMedicineCode == null ? prefix + "00000001" : prefix + String.format("%08d", (new Integer(maxMedicineCode.substring(maxMedicineCode.lastIndexOf("_") + 1)) + 1));
                        healthCareMedicineDirectory1.setMedicineCode(medicineCode);
                        healthCareMedicineDirectory1.setHealthCareArea("370000");
                        healthCareMedicineDirectory1.setHealthCareVersion("001");
                        healthCareMedicineDirectory1.setMedicineName(medicineName);
                        healthCareMedicineDirectory1.setForm(form);
                        healthCareMedicineDirectory1.setHealthCareCategory(healthCareCategory);
                        healthCareMedicineDirectory1.setDirectoryType(directoryType);
                        healthCareMedicineDirectory1.setIsValid("Y");
                        healthCareMedicineDirectory1.setCreatedDate(LocalDateTime.now());
                        healthCareMedicineDirectory1.setUpdatedDate(LocalDateTime.now());

                        healthCareMedicineDirectoryMapper.insertAndSetPkNo(healthCareMedicineDirectory1);
                        healthCareMedicineDirectoryPkNo = healthCareMedicineDirectory1.getPkNo();
                    }
                } else if ("02".equals(directoryType)) {
                    // 中药
                    HealthCareMedicineDirectory healthCareMedicineDirectory = healthCareMedicineDirectoryMapper.getByMedicineName(cname);
                    if (healthCareMedicineDirectory != null) {
                        // 存在则获取主键
                        healthCareMedicineDirectoryPkNo = healthCareMedicineDirectory.getPkNo();
                    } else {
                        // 不存在则新增并获得主键
                        HealthCareMedicineDirectory healthCareMedicineDirectory1 = new HealthCareMedicineDirectory();
                        String prefix = "mkbyb_";
                        String maxMedicineCode = healthCareMedicineDirectoryMapper.getMaxMedicineCode(prefix);
                        String medicineCode = maxMedicineCode == null ? prefix + "00000001" : prefix + String.format("%08d", (new Integer(maxMedicineCode.substring(maxMedicineCode.lastIndexOf("_") + 1)) + 1));
                        healthCareMedicineDirectory1.setMedicineCode(medicineCode);
                        healthCareMedicineDirectory1.setHealthCareArea("370000");
                        healthCareMedicineDirectory1.setHealthCareVersion("001");
                        healthCareMedicineDirectory1.setMedicineName(cname);
                        healthCareMedicineDirectory1.setForm("");
                        healthCareMedicineDirectory1.setHealthCareCategory(healthCareCategory);
                        healthCareMedicineDirectory1.setDirectoryType(directoryType);
                        healthCareMedicineDirectory1.setIsValid("Y");
                        healthCareMedicineDirectory1.setCreatedDate(LocalDateTime.now());
                        healthCareMedicineDirectory1.setUpdatedDate(LocalDateTime.now());


                        healthCareMedicineDirectoryMapper.insertAndSetPkNo(healthCareMedicineDirectory1);
                        healthCareMedicineDirectoryPkNo = healthCareMedicineDirectory1.getPkNo();
                    }
                } else {
                    System.out.println("error:错的的药品类型");
                }
                // 查看对应医保主键的医保支付比例是否存在
                HealthCareMedicinePaymentStandard healthCareMedicinePaymentStandard = healthCareMedicinePaymentStandardMapper.getByMedicineDirectoryPkNoAndPaymentAreaCode(healthCareMedicineDirectoryPkNo, paymentAreaCode);
                if (healthCareMedicinePaymentStandard != null) {
                    // 存在则更新
                    HealthCareMedicinePaymentStandard healthCareMedicinePaymentStandard1 = new HealthCareMedicinePaymentStandard();
                    healthCareMedicinePaymentStandard1.setPkNo(healthCareMedicinePaymentStandard.getPkNo());
                    healthCareMedicinePaymentStandard1.setPaymentProportion(paymentProportion);
                    healthCareMedicinePaymentStandard1.setHealthCareCategory(healthCareCategory);

                    healthCareMedicinePaymentStandardMapper.updateByPkNo(healthCareMedicinePaymentStandard1);
                } else {
                    // 不存在则新增
                    HealthCareMedicinePaymentStandard healthCareMedicinePaymentStandard1 = new HealthCareMedicinePaymentStandard();
                    healthCareMedicinePaymentStandard1.setMedicineDirectoryPkNo(healthCareMedicineDirectoryPkNo);
                    healthCareMedicinePaymentStandard1.setPaymentAreaCode(paymentAreaCode);
                    healthCareMedicinePaymentStandard1.setPaymentProportion(paymentProportion);
                    healthCareMedicinePaymentStandard1.setHealthCareCategory(healthCareCategory);
                    healthCareMedicinePaymentStandard1.setIsValid("Y");
                    healthCareMedicinePaymentStandard1.setCreatedUser("");
                    healthCareMedicinePaymentStandard1.setUpdatedUser("");
                    healthCareMedicinePaymentStandard1.setCreatedDate(LocalDateTime.now());
                    healthCareMedicinePaymentStandard1.setUpdatedDate(LocalDateTime.now());

                    healthCareMedicinePaymentStandardMapper.add(healthCareMedicinePaymentStandard1);
                }
                Integer medicineCommonNamePkNo = 0;
                // 查看医保对应药品通用名是否存在
                MedicineCommonName medicineCommonName = medicineCommonNameMapper.getByMedicineName(cname);
                if (medicineCommonName != null) {
                    // 存在则获得药品通用名主键
                    medicineCommonNamePkNo = medicineCommonName.getPkNo();
                } else {
                    // 不存在则新增并获得药品通用名主键
                    MedicineCommonName medicineCommonName1 = new MedicineCommonName();
                    medicineCommonName1.setMedicineName(cname);
                    medicineCommonName1.setFieldTypeParamCode("");
                    medicineCommonName1.setCreatedUser("");
                    medicineCommonName1.setUpdatedUser("");
                    medicineCommonName1.setCreatedDate(LocalDateTime.now());
                    medicineCommonName1.setUpdatedDate(LocalDateTime.now());


                    medicineCommonNameMapper.insertAndSetPkNo(medicineCommonName1);
                    medicineCommonNamePkNo = medicineCommonName1.getPkNo();
                }
                Integer medicinePkNo = 0;
                // 查看对应医保主键的药品信息是否存在
                Medicine medicine = medicineMapper.getByCommonNamePkNoAndMedicineName(medicineCommonNamePkNo, cname);
                if (medicine != null) {
                    // 存在则获得主键
                    medicinePkNo = medicine.getPkNo();
                } else {
                    // 不存在新增并获得主键
                    Medicine medicine1 = new Medicine();
                    medicine1.setMedicineCode("");
                    medicine1.setCommonNamePkNo(medicineCommonNamePkNo);
                    medicine1.setMedicineName(cname);
                    medicine1.setMedicineForm("");
                    medicine1.setIsHealthCare("Y");
                    medicine1.setIsValid("Y");
                    medicine1.setCreatedUser("");
                    medicine1.setUpdatedUser("");
                    medicine1.setCreatedDate(LocalDateTime.now());
                    medicine1.setUpdatedDate(LocalDateTime.now());


                    medicineMapper.insertAndSetPkNo(medicine1);
                    medicinePkNo = medicine1.getPkNo();
                }
                // 查看医保主键和药品主键的映射是否存在
                HealthCareMedicineMap healthCareMedicineMap = healthCareMedicineMapMapper.getByMedicinePkNo(medicinePkNo);
                if (healthCareMedicineMap != null) {
                    // 存在则更新
                    HealthCareMedicineMap healthCareMedicineMap1 = new HealthCareMedicineMap();
                    healthCareMedicineMap1.setMedicinePkNo(healthCareMedicineMap.getMedicinePkNo());
                    healthCareMedicineMap1.setHealthCareMedicinePkNo(healthCareMedicineDirectoryPkNo);
                    healthCareMedicineMapMapper.updateByMedicinePkNo(healthCareMedicineMap1);
                    System.out.println("映射更新:" + healthCareMedicineMap.getMedicinePkNo() + ">" + healthCareMedicineMap.getHealthCareMedicinePkNo() + ">>>" + healthCareMedicineMap1.getMedicinePkNo() + ">" + healthCareMedicineMap1.getHealthCareMedicinePkNo());
                } else {
                    // 不存在则新增
                    HealthCareMedicineMap healthCareMedicineMap1 = new HealthCareMedicineMap();

                    healthCareMedicineMap1.setMedicinePkNo(medicinePkNo);
                    healthCareMedicineMap1.setHealthCareMedicinePkNo(healthCareMedicineDirectoryPkNo);
                    healthCareMedicineMap1.setCreatedUser("");
                    healthCareMedicineMap1.setUpdatedUser("");
                    healthCareMedicineMap1.setCreatedDate(LocalDateTime.now());
                    healthCareMedicineMap1.setUpdatedDate(LocalDateTime.now());

                    healthCareMedicineMapMapper.add(healthCareMedicineMap1);
                }
                // 查看药品对应药品别名是否存在
                List<MedicineAlias> medicineAliasList = medicineAliasMapper.getByCommonNamePkNoAndMedicineAliasName(medicineCommonNamePkNo, cname);
                MedicineAlias medicineAlias = medicineAliasList.size() > 0 ? medicineAliasList.get(0) : null;
                if (medicineAlias != null) {
                    // 存在则跳过

                } else {
                    // 不存在则新增
                    MedicineAlias medicineAlias1 = new MedicineAlias();
                    medicineAlias1.setCommonNamePkNo(medicineCommonNamePkNo);
                    medicineAlias1.setMedicineAliasName(cname);
                    medicineAlias1.setIsValid("Y");
                    medicineAlias1.setCreatedUser("");
                    medicineAlias1.setUpdatedUser("");
                    medicineAlias1.setCreatedDate(LocalDateTime.now());
                    medicineAlias1.setUpdatedDate(LocalDateTime.now());
                    medicineAlias1.setIsSplit("N");
                    medicineAlias1.setIsEncoded("N");
                    medicineAlias1.setIsCommon("Y");

                    medicineAliasMapper.add(medicineAlias1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        }
    }

}
