package javaStudy.tools.mybatis;

import javaStudy.tools.mybatis.entity.HealthCareMedicineDirectory;
import javaStudy.tools.mybatis.entity.IncludedPayment;
import javaStudy.tools.mybatis.entity.PaymentNew;
import javaStudy.tools.mybatis.mapper.HealthCareMedicineDirectoryMapper;
import javaStudy.tools.mybatis.mapper.IncludedPaymentMapper;
import javaStudy.tools.mybatis.mapper.PaymentNewMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
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
        IncludedPaymentMapper includedPaymentMapper = sqlSession.getMapper(IncludedPaymentMapper.class);
        HealthCareMedicineDirectoryMapper healthCareMedicineDirectoryMapper = sqlSession.getMapper(HealthCareMedicineDirectoryMapper.class);
        PaymentNewMapper paymentNewMapper = sqlSession.getMapper(PaymentNewMapper.class);
        List<IncludedPayment> includedPayments = includedPaymentMapper.list();
        for (IncludedPayment includedPayment : includedPayments) {
            // 找到同样的医保编码但是不是本身
            List<HealthCareMedicineDirectory> healthCareMedicineDirectories = healthCareMedicineDirectoryMapper.getByMedicineCodeAndForm(includedPayment.getDirectoryMedicineCode(), includedPayment.getDirectoryType(), includedPayment.getDirectoryForm());
            if (healthCareMedicineDirectories.size() > 0) {
                for (HealthCareMedicineDirectory healthCareMedicineDirectory : healthCareMedicineDirectories) {
                    PaymentNew paymentNew = new PaymentNew();
                    paymentNew.setPkNo(includedPayment.getPkNo());
                    paymentNew.setMedicineDirectoryPkNo(includedPayment.getMedicineDirectoryPkNo());
                    paymentNew.setNewMedicineDirectoryPkNo(healthCareMedicineDirectory.getPkNo());
                    paymentNewMapper.add(paymentNew);
                }
            } else {
                PaymentNew paymentNew = new PaymentNew();
                paymentNew.setPkNo(includedPayment.getPkNo());
                paymentNew.setMedicineDirectoryPkNo(includedPayment.getMedicineDirectoryPkNo());
                paymentNew.setNewMedicineDirectoryPkNo(null);
                paymentNewMapper.add(paymentNew);
            }
        }
    }

}
