package z;

public class Abcd {
		public static void main(String[] args) {
			String str="ABCD";
			byte[] bys=str.getBytes();
			StringBuilder sBuilder = new StringBuilder("");
			for (byte b : bys) {
				sBuilder.append((char)b).append(",");
			}
			sBuilder.deleteCharAt(sBuilder.length()-1);
			System.out.println(sBuilder.toString());
		}
}
