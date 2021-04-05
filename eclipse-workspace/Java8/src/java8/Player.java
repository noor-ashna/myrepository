package java8;

 interface Player {
	
	public int run(int num);

	
	public static void main(String[] args) {
		
	
		Player speak = new Player() {

			@Override
			public int run(int num) {
			return 100*num;
			}
			
		  };
		  
		  Player speak2 = (int num)->{
			  return 100*num;
		  
     	};
     	
     	  Player speak3 = (num)->{
			  return 100*num;
     	  };
     	  Player speak4 = num->{
			  return 100*num;
     	  };
      	  Player speak5 = num-> 100*num;
     	}
	}
