package Maven1.Project1;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class UtilityPage {
	public static String uname;
	public static String pwd;
	public static String invalidPwd;

	public void datafetch() throws EncryptedDocumentException, IOException {
		FileInputStream f1 = new FileInputStream(
				"C:\\Users\\rizva\\eclipse-workspace\\MProjectAmazon1\\DataProvider\\Rijwan.xlsx");
		Workbook w = WorkbookFactory.create(f1);
		uname = w.getSheet("login").getRow(0).getCell(0).getStringCellValue();
		pwd = w.getSheet("login").getRow(0).getCell(1).getStringCellValue();
		invalidPwd=w.getSheet("login").getRow(1).getCell(1).getStringCellValue();
	}
}
