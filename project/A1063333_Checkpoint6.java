import java.io.*;
import java.util.*;
import java.util.Map.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.*;
public class A1063333_Checkpoint6 {
	public static ArrayList<Character> player=new ArrayList<Character>();
	public static Map<Integer, Land> landmap = new HashMap<Integer, Land>();
	public static int playeramount,turn,round,dicenum,previouslocation,previousturn;
	private static final String protocol = "jdbc:mysql:"; 
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String url = "//localhost:3306/";
    private static Statement s;
	private static ResultSet rs;
	private static ArrayList<Integer> switchnum=new ArrayList<Integer>();
	public static void main(String[] args) throws IOException{	
		//Load("Character.txt","Land.txt");
		A1063333_GUI gui=new A1063333_GUI();
		gui.setVisible(true);
	}	
	static void Load(String filename,String filename2) throws IOException {
		player.clear();
		try {	
			BufferedReader br=new BufferedReader(new FileReader(filename));
			String str="";
			ArrayList<String> list=new ArrayList<String>();
			String[] box1=new String[3];
            String[] box2=new String[2];
			int flag=0;
			playeramount=0;
			while((str=br.readLine())!=null) {
				if(flag==0) {
					flag++;
                    box1=str.split(":");
                    turn=Integer.parseInt(box1[2]);
                    box2=box1[1].split(",");
                    round=Integer.parseInt(box2[0]);
					continue;
				}
				for(String line:str.split(",")) {
					list.add(line);
				}
				player.add(new Character(Integer.parseInt(list.get(0)),Integer.parseInt(list.get(1)),
						Integer.parseInt(list.get(2)),Integer.parseInt(list.get(3)),list.get(4)));
				list.removeAll(list);
				playeramount++;
			}
			br.close();
		}
		catch(IOException e){
			System.out.println(e.getMessage());
		}
		switchnum.clear();
		for(int i=0;i<playeramount;i++) {
			switchnum.add(player.get(i).CHARACTER_NUMBER);
		}
		turn=switchnum.indexOf(turn)+1;
		try {
			Class.forName(driver);
			System.out.println("Loaded the embedded driver.");
		}catch(Exception err) {
			System.err.println("Unable to load the embedded driver.");
			err.printStackTrace(System.err);
			System.exit(0);
		}
		BufferedReader br2=new BufferedReader(new FileReader(filename2));
		String str2="";
		int flag2=0;
		ArrayList<String> list2=new ArrayList<String>();
		while((str2=br2.readLine())!=null) {
			if(flag2==0) {
				flag2++;
				continue;
			}
			for(String line2:str2.split(",")) {
				list2.add(line2);
			}
			String dbName = "CHECKPOINT";
			Connection conn = null;
			try {
				conn = DriverManager.getConnection(protocol + url + "?serverTimezone=UTC","roger","aZxcv7904");
				s = conn.createStatement();
				s.execute("USE "+dbName);
				String query="SELECT * FROM LAND WHERE PLACE_NUMBER="+list2.get(0);
				rs = s.executeQuery(query);
				while(rs.next()) {
					landmap.put(Integer.parseInt(list2.get(0)),new Land(Integer.parseInt(list2.get(0)), Integer.parseInt(list2.get(1)), rs.getInt("LAND_PRICE"), rs.getInt("TOLLS")));
				}
				conn.close();
			}catch(SQLException err) {
				err.printStackTrace(System.err);
			}
			list2.removeAll(list2);
		}
		br2.close();
	}
	static void Save(String filename,String filename2) throws IOException {
		turn=switchnum.get(turn-1);
		try {
			PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter(filename)));
			pw.println("Round:"+round+",Turn:"+turn);
			for(int i=0;i<playeramount;i++) {
				pw.println(player.get(i).location+","+player.get(i).CHARACTER_NUMBER+","+player.get(i).money+","+player.get(i).status+","+player.get(i).IMAGE_FILENAME);
			}
			pw.close();
		}
		catch(IOException e){
			System.out.println(e.getMessage());
		}
		try {
			PrintWriter pw2=new PrintWriter(new BufferedWriter(new FileWriter(filename2)));
			pw2.println("LOCATION_NUMBER, owner");
			for(int i=1;i<=4;i++){
				pw2.println(landmap.get(i).PLACE_NUMBER+","+landmap.get(i).owner);
			}
			for(int i=6;i<=9;i++){
				pw2.println(landmap.get(i).PLACE_NUMBER+","+landmap.get(i).owner);
			}
			for(int i=11;i<=14;i++){
				pw2.println(landmap.get(i).PLACE_NUMBER+","+landmap.get(i).owner);
			}
			for(int i=16;i<=19;i++){
				pw2.println(landmap.get(i).PLACE_NUMBER+","+landmap.get(i).owner);
			}
			pw2.close();
		}
		catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
	static void Random() {
		boolean iszeroflag=true;
		for(int i=0;i<playeramount;i++) {
			if(player.get(i).status>0){
				iszeroflag=false;
			}
		}
		if(iszeroflag) {
			for(int i=0;i<playeramount;i++) {
				player.get(i).status+=1;
			}
		}
		dicenum=(int)(Math.random()*6+1);
		previousturn=turn;
		previouslocation=player.get(turn-1).location;
		if ((player.get(turn-1).location+dicenum)>19){
			player.get(turn-1).location=player.get(turn-1).location+dicenum-20;
		} else {
			player.get(turn-1).location+=dicenum;
		}
		if(turn<playeramount) {
			turn++;
		}
		else {
			turn=1;
			round++;
		}
		int flag;
		do {
			flag=turn;
			if(player.get(turn-1).status<=0){
				player.get(turn-1).status+=1;
				if(turn<playeramount) {
					turn++;
				}
				else {
					turn=1;
					round++;
				}
			}
		}while(flag!=turn);
	   }
}

