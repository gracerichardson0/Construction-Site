public class Contractor {
   private String firstName;
   private String lastName;
   private double salary;
   
   public Contractor() {}
   
   public Contractor(String firstName, String lastName, double salary) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.salary = salary;
   }
   
   public String getFirstName() { return this.firstName; }
   public String getLastName() { return this.lastName; }
   public double getSalary() { return this.salary; }
   
   public boolean setFirstName(String firstName) {
      if (firstName.equals("")) {
         return false;
      }
      else {
         this.firstName = firstName;
         return true;
      }
   }

   public boolean setLastName(String lastName) {
      if (lastName.equals("")) {
         return false;
      }
      else {
         this.lastName = lastName;
         return true;
      }
   }

   public boolean setSalary(double salary) {
      if (salary < 0.0) {
         return false;
      }
      else {
         this.salary = salary;
         return true;
      }
   }
   
   public String toString() {
      return "Name: " + this.getFirstName() + " " + this.getLastName()
         + "\nSalary: " + String.format("$%.2f", this.getSalary());
   }
}