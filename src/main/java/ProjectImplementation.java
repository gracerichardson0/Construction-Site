import javax.swing.JOptionPane;
public class ProjectImplementation {
   public static void main(String[] args) {
      
      Project[] portfolio = new Project[10];
      int numProjects = addProjects(portfolio);
      printPortfolio(portfolio,numProjects);
   }
   
   private static void printPortfolio(Project[] portfolio, int numProjects)
   {
      String output = "Business Portfolio:\n";
      for(int x=0; x <numProjects; x++)
      {
         output += "\n" + portfolio[x].toString();
      }
            
      JOptionPane.showMessageDialog(null,output);  
   }
   
   private static int addProjects(Project[] portfolio)
   {
      int counter = 0;
      do
      {
         portfolio[counter++] = addProject();
      }while(counter < portfolio.length && JOptionPane.showConfirmDialog(null,"Add another project?") ==
             JOptionPane.YES_OPTION);
             
      return counter;       
   }
   
   private static Project addProject()
   {
      Project project = new Project();
      
      //Populate the basic properites
      boolean valid = false;
      
      //Project Name
      do
      {
         valid = project.setName(JOptionPane.showInputDialog("Enter project name: "));   
      }while(!valid);
      
      //Project Duration
      valid = false;
      do
      {
         try
         {
            valid = project.setNumMonths(Double.parseDouble(JOptionPane.showInputDialog("Enter project duration: ")));               
         }
         catch(NumberFormatException e){}   
      }while(!valid);
      
      
      //Gather site properties
      addSite(project);
      
      //Add contractors to the project
      addContractors(project);
      
      return project;      
   }
   
   private static void addContractors(Project project)
   {
      do
      {
         int position = project.setContractor();
         if(position > -1)
         {
            boolean valid = false;
            do
            {
               valid = project.getContractor(position).setFirstName(JOptionPane.showInputDialog("Enter contractor first name: "));
            }while(!valid);
                        
            valid = false;
            do
            {
               valid = project.getContractor(position).setLastName(JOptionPane.showInputDialog("Enter contractor last name: "));
            }while(!valid);
            
            valid = false;
            do
            {
               try
               {
                  valid = project.getContractor(position).setSalary(Double.parseDouble(JOptionPane.showInputDialog("Enter contractor salary: ")));
               }
               catch(NumberFormatException e){}   
            }while(!valid);
         }
         else
         { 
            JOptionPane.showMessageDialog(null, "No more contractors can be added.");
         }
      
      }while(JOptionPane.showConfirmDialog(null,"Add another contractor?") == 
             JOptionPane.YES_OPTION && project.getNumContractors() < Project.MAX_CONTRACTORS);
   }
   
   private static void addSite(Project project)
   {
      //Prompt for street
      boolean valid = false;
      do
      {
         valid = project.getSite().setStreet(JOptionPane.showInputDialog("Enter project street: "));
      }while(!valid);
      
      //Prompt for city
      valid = false;
      do
      {
         valid = project.getSite().setCity(JOptionPane.showInputDialog("Enter project city: "));
      }while(!valid);
      
      //Prompt for state
      valid = false;
      do
      {
         valid = project.getSite().setState(JOptionPane.showInputDialog("Enter project state: "));
      }while(!valid);
      
      //Prompt for zip code
      valid = false;
      do
      {
         valid = project.getSite().setZip(JOptionPane.showInputDialog("Enter project zip code: "));
      }while(!valid);
   }
   
   
     
}