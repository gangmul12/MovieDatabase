public abstract class AbstractCommand implements Command {
	@Override
	public void apply(MovieDatabase db, String args) throws DatabaseException {
		String[] arga = parse(args);
		queryDatabase(db, arga);
	}

	private String[] parse(String args) throws CommandParseException {
		if (args.isEmpty()) {
			return new String[] {};
		} else {
			
			//parse input between the first %pair
			int startIndex = args.indexOf("%");
			int endIndex = args.indexOf("%", startIndex+1);
			if(startIndex==-1||endIndex==-1)
				throw new CommandParseException("No Command", "No argument", "Not Found %pair");
			
			if(args.indexOf("%", endIndex+1)==-1){//if second args not exists
				String[] result = new String[1];
				result[0]=args.substring(startIndex+1, endIndex);
				if(result[0].charAt(0)==' ')
					result[0]=result[0].replaceFirst("\\s*", "");
				if(result[0].charAt(result[0].length()-1)==' ')
					result[0]=result[0].replaceAll("\\s*$", "");
				return result;
			}
			
			String[] result = new String[2];
			result[0]=args.substring(startIndex+1, endIndex);
			if(result[0].charAt(0)==' ')
				result[0]=result[0].replaceFirst("\\s*", "");
			if(result[0].charAt(result[0].length()-1)==' ')
				result[0]=result[0].replaceAll("\\s*$", "");
			//parse input between the second %pair
			startIndex = args.indexOf("%", endIndex+1);
			endIndex = args.indexOf("%", startIndex+1);
			if(endIndex==-1)
				throw new CommandParseException("Insert Or Delete", args.substring(startIndex+1), "Not Found Closing %");
			result[1]=args.substring(startIndex+1, endIndex);
			if(result[1].charAt(0)==' ')
				result[1]=result[1].replaceFirst("\\s*", "");
			if(result[1].charAt(result[1].length()-1)==' ')
				result[1]=result[1].replaceAll("\\s*$", "");
			
			if(!args.substring(endIndex+1).replaceAll(" ", "").isEmpty())
				throw new CommandParseException("Unknown",args.substring(endIndex+1),"has too many words");
			return result;
			// FIXME implement this
			// Parse the input appropriately.
			// You may need to change the return value.
			
		}
	}

	protected abstract void queryDatabase(MovieDatabase db, String[] arga) throws DatabaseException;
}
