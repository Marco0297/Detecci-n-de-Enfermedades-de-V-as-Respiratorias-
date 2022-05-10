/*
UNIVERSIDAD AUTONOMA DEL ESTADO DE MÉXICO
EQUIPO: MARCO ANTONIO SÁNCHEZ CONTRERAS
        ERIK ZAYAGO GUZMAN
 */
import Rule.*;//importa todos los componentes de la Libreria Rule

public class SistEx {

    BooleanRuleBase bdr = new BooleanRuleBase("bdr");//Objeto para Base de Reglas
    //Variables de regla
    RuleVariable Zapatillas;
    RuleVariable Zapatos;
    RuleVariable Pico;
    RuleVariable Collar;
    RuleVariable OrejasR;

    //Variables para guardar el resultado
    RuleVariable resultadoCalzado;
    RuleVariable resultadoPico;
    RuleVariable resultadoCollar;
    RuleVariable resultadoOrejasR;

    String resultado = "";

    public String obtenerCalzado(String zapatillas, String zapatos) {
        baseDeconocimiento();
        Zapatillas.setValue(zapatillas);
        Zapatos.setValue(zapatos);

        bdr.forwardChain();//Motor de Inferencia hacie adelante
        resultado = resultadoCalzado.getValue();
        /*
        Si no se encuentra esta regla, devuelve valo nulo
         */
        return resultado;
    }

    public String obtenerResultadoPico(String ResultadoCalzado, String pico) {
        baseDeconocimiento();
        resultadoCalzado.setValue(ResultadoCalzado);
        Pico.setValue(pico);

        bdr.forwardChain();//Motor de Inferencia hacie adelante
        resultado = resultadoPico.getValue();
        /*
        Si no se encuentra esta regla, devuelve valo nulo
         */
        return resultado;
    }

    public String obtenerResultadoOrejas(String ResultadoCalzado, String orejasR) {
        baseDeconocimiento();
        resultadoCalzado.setValue(ResultadoCalzado);
        OrejasR.setValue(orejasR);

        bdr.forwardChain();//Motor de Inferencia hacie adelante
        resultado = resultadoOrejasR.getValue();
        /*
        Si no se encuentra esta regla, devuelve valo nulo
         */
        return resultado;
    }

    public String obtenerResultadoCollar(String ResultadoCalzado, String collar) {
        baseDeconocimiento();
        resultadoCalzado.setValue(ResultadoCalzado);
        Collar.setValue(collar);

        bdr.forwardChain();//Motor de Inferencia hacie adelante
        resultado = resultadoCollar.getValue();
        /*
        Si no se encuentra esta regla, devuelve valo nulo
         */
        return resultado;
    }

    //Base de Conocimiento
    public void baseDeconocimiento() {
        //Instanciar variables
        Zapatillas = new RuleVariable(bdr, "");
        Zapatos = new RuleVariable(bdr, "");
        Pico = new RuleVariable(bdr, "");
        Collar = new RuleVariable(bdr, "");
        OrejasR = new RuleVariable(bdr, "");

        resultadoCalzado = new RuleVariable(bdr, "");
        resultadoPico = new RuleVariable(bdr, "");
        resultadoCollar = new RuleVariable(bdr, "");
        resultadoOrejasR = new RuleVariable(bdr, "");

        //CrearCondición
        Condition igual = new Condition("=");

        //CrearReglas
        //Reglas para el Calzado
        Rule regla_1 = new Rule(bdr, "regla_1",
                new Clause[]{
                    new Clause(Zapatillas, igual, "si"),
                    new Clause(Zapatos, igual, "no")},
                new Clause(resultadoCalzado, igual, "Tiene Zapatillas")
        );//Regla 1
        Rule regla_2 = new Rule(bdr, "regla_2",
                new Clause[]{
                    new Clause(Zapatillas, igual, "no"),
                    new Clause(Zapatos, igual, "si")},
                new Clause(resultadoCalzado, igual, "Tiene Zapatos")
        );//Regla 2
        Rule regla_3 = new Rule(bdr, "regla_3",
                new Clause[]{
                    new Clause(Zapatillas, igual, "no"),
                    new Clause(Zapatos, igual, "no")},
                new Clause(resultadoCalzado, igual, "No Tiene Calzado")
        );//Regla 3
        Rule regla_4 = new Rule(bdr, "regla_4",
                new Clause[]{
                    new Clause(resultadoCalzado, igual, "Tiene Zapatillas"),
                    new Clause(Pico, igual, "si")},
                new Clause(resultadoPico, igual, "Es Deisy")
        );//Regla 4
        Rule regla_5 = new Rule(bdr, "regla_5",
                new Clause[]{
                    new Clause(resultadoCalzado, igual, "Tiene Zapatillas"),
                    new Clause(Pico, igual, "no")},
                new Clause(resultadoPico, igual, "Es Mimie")
        );//Regla 5
        Rule regla_6 = new Rule(bdr, "regla_6",
                new Clause[]{
                    new Clause(resultadoCalzado, igual, "Tiene Zapatos"),
                    new Clause(OrejasR, igual, "si")},
                new Clause(resultadoOrejasR, igual, "Es Micky")
        );//Regla 6
        Rule regla_7 = new Rule(bdr, "regla_7",
                new Clause[]{
                    new Clause(resultadoCalzado, igual, "Tiene Zapatos"),
                    new Clause(OrejasR, igual, "no")},
                new Clause(resultadoOrejasR, igual, "Es Goofy")
        );//Regla 7
        Rule regla_8 = new Rule(bdr, "regla_8",
                new Clause[]{
                    new Clause(resultadoCalzado, igual, "No Tiene Calzado"),
                    new Clause(Collar, igual, "si")},
                new Clause(resultadoCollar, igual, "Es Pluto")
        );//Regla 8
        Rule regla_9 = new Rule(bdr, "regla_9",
                new Clause[]{
                    new Clause(resultadoCalzado, igual, "No Tiene Calzado"),
                    new Clause(Collar, igual, "no")},
                new Clause(resultadoCollar, igual, "Donald")
        );//Regla 9
    }
;//baseDeConocimineto
}//SistExp
