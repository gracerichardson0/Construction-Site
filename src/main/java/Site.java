public class Site {
   private String street;
   private String city;
   private String state;
   private String zip;
   
   public Site() {}
   
   public Site(String street, String city, String state, String zip) {
      this.street = street;
      this.city = city;
      this.state = state;
      this.zip = zip;
   }
   
   public String getStreet() { return this.street; }
   public String getCity() { return this.city; }
   public String getState() { return this.state; }
   public String getZip() { return this.zip; }
   
   public boolean setStreet(String street) {
      if (street.equals("")) {
         return false;
      }
      else {
         this.street = street;
         return true;
      }
   }

   public boolean setCity(String city) {
      if (city.equals("")) {
         return false;
      }
      else {
         this.city = city;
         return true;
      }
   }
   
   public boolean setState(String state) {
      if (state.equals("")) {
         return false;
      }
      else {
         this.state = state;
         return true;
      }
   }

   public boolean setZip(String zip) {
      if (zip.equals("")) {
         return false;
      }
      else {
         this.zip = zip;
         return true;
      }
   }
            
   public String toString() {
      return "[" + getClass().getName() + "]\n"
         + this.getStreet()
         + "\n" + this.getCity() + ", "
         + this.getState() + " "
         + this.getZip();
   }
}