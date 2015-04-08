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
				throw new CommandParseException("not print", "args", "Not Found %pair");
			
			if(args.indexOf("%", endIndex+1)==-1){//if second args not exists
				String[] result = new String[1];
				result[0]=args.substring(startIndex+1, endIndex);
				if(result[0].isEmpty())
					throw new CommandParseException("Search", "arg", "Argument is Empty");
				return result;
			}
			
			String[] result = new String[2];
			result[0]=args.substring(startIndex+1, endIndex);
			if(result[0].isEmpty())
				throw new CommandParseException("Unknown", "arg", "Argument is Empty");
			//parse input between the second %pair
			startIndex = args.indexOf("%", endIndex+1);
			String shouldEmpty = args.substring(endIndex+1, startIndex);
			shouldEmpty=shouldEmpty.replace(" ", "");
			if(!shouldEmpty.isEmpty())
				throw new CommandParseException("Unknown",shouldEmpty,"there is string between %pairs");
			endIndex = args.indexOf("%", startIndex+1);
			if(endIndex==-1)
				throw new CommandParseException("Insert Or Delete", args.substring(startIndex+1), "Not Found Closing %");
			result[1]=args.substring(startIndex+1, endIndex);
			if(result[1].isEmpty())
				throw new CommandParseException("Unknown", "arg", "Argument is Empty");
			
			if(!args.substring(endIndex+1).replaceAll(" ", "").isEmpty())
				throw new CommandParseException("Unknown",args.substring(endIndex+1),"has too many words");
			return result;
			
		}
	}

	protected abstract void queryDatabase(MovieDatabase db, String[] arga) throws DatabaseException;
}
