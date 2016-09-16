package test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Date;
import java.util.Locale;

import org.springframework.context.MessageSource;

public class Cashier {
	/*private MessageSource messageSource;

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public void checkout(ShoppingCart cart) throws IOException {
		String alert = messageSource.getMessage("alert.inventory.checkout",
				new Object[] { cart.getItems(), new Date() }, Locale.US);
		System.out.println(alert);
	}
*/
	private String fileName;
	private String path;
	private BufferedWriter writer;

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void openFile() throws IOException {
		File targetDir = new File(path);
		if (!targetDir.exists()) {
			targetDir.mkdir();
		}
		File checkoutFile = new File(path, fileName + ".txt");
		if (!checkoutFile.exists()) {
			checkoutFile.createNewFile();
		}
		writer = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(checkoutFile, true)));
	}

	public void checkout(ShoppingCart cart) throws IOException {
		writer.write(new Date() + "\t" + cart.getItems() + "\r\n");
		writer.flush();
	}

	public void closeFile() throws IOException {
		writer.close();
	}

}