import java.util.Arrays;

public class PrintCmd extends AbstractCommand {
	@Override
	protected void queryDatabase(MovieDatabase db, String[] arga) throws DatabaseException {
		checkArga(arga);
		MyLinkedList<QueryResult> result = db.search(null);

		for (QueryResult item: result) {
			System.out.printf("(%s, %s)\n", item.getGenre(), item.getTitle());
		}
	}

	private void checkArga(String[] arga) throws DatabaseException {
		if (arga.length != 0)
			throw new CommandParseException("PRINT", Arrays.toString(arga), "unnecessary argument(s)");
	}
}