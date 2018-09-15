public class Project {
   private String name;
   private double numMonths;
   private Site site;
   private Contractor[] contractors;
   private int numContractors;
   public static final int MAX_CONTRACTORS = 50;
   
   public Project() {
      this.site = new Site();
      this.contractors = new Contractor[MAX_CONTRACTORS];
   }
   
   public Project(String name, double numMonths, String street, String city, String state, String zip, Contractor[] contractors) {
      this();
      this.name = name;
      this.numMonths = numMonths;   
      this.site = new Site(street,city,state,zip);
      
      for(int x=0; x < contractors.length; x++)
      {
         this.contractors[x] = contractors[x];
         this.numContractors++;
      }        
   }
   
   public Site getSite(){ return this.site; }
   
   public Contractor getContractor(int index)
   {
      return this.contractors[index];
   }
   
   public int getNumContractors(){ return this.numContractors; }
   
   public String getName() { return this.name; }
   public double getNumMonths() { return this.numMonths; }
   
   public boolean setName(String name) {
      if (name.equals("")) {
         return false;
      }
      else {
         this.name = name;
         return true;
      }
   }

   public boolean setNumMonths(double numMonths) {
      if (numMonths <= 0.0) {
         return false;
      }
      else {
         this.numMonths = numMonths;
         return true;
      }
   }
   
   public void setSite(){ this.site = new Site(); }
     
   public void setSite(String street, String city, String state, String zip)
   { 
      this.site = new Site(street,city,state,zip); 
   }
   
   public int setContractor()
   {
      if(this.numContractors < MAX_CONTRACTORS)
      {
         int index = this.numContractors;
         this.contractors[this.numContractors++] = new Contractor();
         return index;
      }
      else{ return -1; }
   }
   
   public boolean setContractors(Contractor[] contractors)
   {
      if(contractors.length <= MAX_CONTRACTORS)
      {
         this.contractors = new Contractor[MAX_CONTRACTORS];
         for(int x=0; x < contractors.length; x++)
         {
            this.contractors[x] = contractors[x];
            this.numContractors++;
         }         
         return true;
      }   
      else{ return false; }      
   }

   public String toString() {
      String value = "[" + getClass().getName() + "]\n"
         + "Name: " + this.getName()
         + "\nNumber of Months: " + String.format("%.1f", this.getNumMonths())
         + "\n" + this.site.toString()
         + "\n\nContractors: \n";
         
      for(int x=0; x < this.numContractors; x++)
      {
         value += this.contractors[x].toString() + "\n\n";
      }
      
      return value;
   }
}