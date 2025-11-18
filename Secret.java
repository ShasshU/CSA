public class Secret 
{
	public String secretMurderer()
	{
		int m = (int)(Math.random()*6);
		if (m == 0)
		{
			return "Miss Scarlett";
		}
		else if (m == 1)
		{
			return "Mr. Green";
		}
		else if (m == 2)
		{
			return "Colonel Mustard";
		}
		else if (m == 3)
		{
			return "Professor Plum";
		}
		else if (m == 4)
		{
			return "Mrs. Peacock";
		}
		else
		{
			return "Mrs. White";
		}
	}
	
	public String secretWeapon()
	{
		int w = (int)(Math.random()*6);
    	switch(w)
    	{
		case 0:
			return "Candlestick";
		case 1:
			return "Knife";
		case 2:
			return "Lead Pipe";
		case 3:
			return "Revolver";
		case 4:
			return "Rope";
		default:
			return "Wrench";
    	}
	}
	
	public String secretRoom()
	{
		int r = (int)(Math.random()*9);
    	switch(r)
    	{
		case 0:
			return "Kitchen";
		case 1:
			return "Ballroom";
		case 2:
			return "Conservatory";
		case 3:
			return "Billiard Room";
		case 4:
			return "Library";
		case 5:
			return "Study";
		case 6:
			return "Hall";
		case 7:
			return "Lounge";
		default:
			return "Dining Room";
    	}
	}
}