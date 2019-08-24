package principal;

import controladores.ControladorPrincipal;
import jade.core.Profile; 
import jade.core.ProfileImpl; 
import jade.wrapper.*;
import jade.core.Runtime; 
import javax.swing.UIManager;

public class Principal {

    public static void main(String[] args) {
        new ControladorPrincipal();
      /*  try {
            // Usar look & feel nativo en las vistas
            UIManager.setLookAndFeel(
            UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {}

        // Plataforma JADE
        Runtime runtime = Runtime.instance();

        // Perfil predetermiando (localhost:1099)
        Profile profile = new ProfileImpl();

        // Contenedor principal
        AgentContainer mainContainer = runtime.createMainContainer(profile);

        // Crear agentes
        try {
            // RMA (Jade Boot GUI)
            AgentController ac = mainContainer.createNewAgent("rma",
                    "jade.tools.rma.rma", null);
            ac.start();

            // Planificador
            ac = mainContainer.createNewAgent("Planificador",
                    "src.agentes.Planificador", null);
            ac.start();

            // 4 personas
            String[] personas = {"Eleazar", "Stefan", "German", "Bachaquero"};
            for(int i = 0; i < personas.length; i++) {
               ac = mainContainer.createNewAgent(personas[i],
                        "src.agentes.Persona", null);
                ac.start();
            }
        } catch (StaleProxyException e) {
            e.printStackTrace();
        }*/
    }
}
