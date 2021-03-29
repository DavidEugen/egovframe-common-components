package egovframework.com.uss.umt.validation;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import egovframework.rte.ptl.mvc.validation.RteGenericValidator;

/**
 * 비밀번호 생성 Test Class 구현
 * @author 표준프레임워크 윤주호
 * @since 2020.10.07
 * @version 3.10
 * @see
 * <pre>
 *
 *  수정일         수정자          수정내용
 *  ----------   ------------  ---------------------------
 *  2020.10.07   윤주호          최초 생성 (실행환경 테스트케이스에서 복사)
 *  2020.10.08   신용호          주민번호 샘플 수정 
 *
 * </pre>
 */


public class PasswordValidationTest {
	
	String[] password = {
			"1234567", "123456789012345678901", "한글패스워드입니다.", " 12345678",
			"abcdaaee", "abcaabbee", "aaaatest", "aaatesta", 
			"#!@#^#$#@", "\ttesttest"
		};
	
	@Test
	public void testPassword1() {
		String[] notOk = { "1234567", "123456789012345678901" };
		String[] ok = { "12345678", "12345678901234567890" };
		
		for (int i = 0; i < notOk.length; i++) {
			assertFalse(RteGenericValidator.checkLength(notOk[i]));
		}
		
		for (int i = 0; i < ok.length; i++) {
			assertTrue(RteGenericValidator.checkLength(ok[i]));
		}
	}
	
	@Test
	public void testPassword2() {
		String[] notOk = { "한글패스워드입니다", "abc def" };
		String[] ok = { "abcdefgh", "12345678", "#!@#^#$#@" };
		
		for (int i = 0; i < notOk.length; i++) {
			assertFalse(RteGenericValidator.checkCharacterType(notOk[i]));
		}
		
		for (int i = 0; i < ok.length; i++) {
			assertTrue(RteGenericValidator.checkCharacterType(ok[i]));
		}
	}
	
	@Test
	public void testPassword3() {
		String[] notOk = { "abcdaaee" };
		String[] ok = { "abcaabbee", };
		
		for (int i = 0; i < notOk.length; i++) {
			assertFalse(RteGenericValidator.checkSeries(notOk[i]));
		}
		
		for (int i = 0; i < ok.length; i++) {
			assertTrue(RteGenericValidator.checkSeries(ok[i]));
		}
	}
	
	@Test
	public void testPassword4() {
		String[] notOk = { "aaaatest" };
		String[] ok = { "aaatesta", };
		
		for (int i = 0; i < notOk.length; i++) {
			assertFalse(RteGenericValidator.checkSeries(notOk[i]));
		}
		
		for (int i = 0; i < ok.length; i++) {
			assertTrue(RteGenericValidator.checkSeries(ok[i]));
		}
	}

	
	@Test
	public void testIdIhNum() {
		// - 없이 입력되어야 한다.
		String[] notOk = { "7612041110411", "7612049110419", "7613041110410" };//주민등록번호 확인 필요
		String[] ok = { "7612041110470" };
		
		for (int i = 0; i < notOk.length; i++) {
			assertFalse(RteGenericValidator.isValidIdIhNum(notOk[i]));
		}
		
		for (int i = 0; i < ok.length; i++) {
			assertTrue(RteGenericValidator.isValidIdIhNum(ok[i]));
		}
	}
	
}