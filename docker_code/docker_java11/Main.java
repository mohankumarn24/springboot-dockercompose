import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

	public static void main(String[] args) {

		while (true) {
			// Current time with offset (e.g. +05:30)
			OffsetDateTime offsetDateTime = OffsetDateTime.now();
			System.out.println("OffsetDateTime	: " + offsetDateTime.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME));

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(String.format("Exception occurred: ", e.getMessage()));
			}
		}
	}
}
