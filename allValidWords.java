
	public boolean isUnique(String s){
		
		for(int i=0;i<s.length();i++)
		{
			char t=s.indexOf(i);
		
			for(int j=i+1;j<s.length();j++)
			{
				if(t!=s.indexOf(j))
					continue;
				else
					return false;
			}
			
			return true;
			
			
		
		}
		
			
			
		
	}
	
	public void allValidWords()
	{ 	Map <Integer, String> allValidOnes= new HashMap<Integer, String>();
		String file = "Downloads/words.txt";
	
		Scanner sc = new Scanner(new File(file));
	    while(sc.hasNext())
	    {
	        String s = sc.next();
	    if(isUnique(s))
	    {
	    	allValidOnes.put(s.length(),s);
	    	
	    }
	    
	    	
	    
	        
	    
	    }
	    
	}  
