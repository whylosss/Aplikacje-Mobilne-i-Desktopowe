import javax.swing.*;

public class GlownyController
{

    private GlownyView view;
    private UzytkownikModel model;

    public GlownyController(GlownyView view, UzytkownikModel model)
    {
        this.view = view;
        this.model = model;

        view.przyciskZaloguj.addActionListener(e -> obsluzLogowanie());
    }

    private void obsluzLogowanie()
    {
        String login = view.poleLogin.getText();
        String haslo = new String(view.poleHaslo.getPassword());

        SwingWorker<Boolean, Void> worker = new SwingWorker<>()
        {

            @Override
            protected Boolean doInBackground()
            {
                view.przyciskZaloguj.setEnabled(false);
                view.etykietaStatusu.setText("Trwa weryfikacja danych...");
                return model.walidujLogowanie(login, haslo);
            }

            @Override
            protected void done()
            {
                view.przyciskZaloguj.setEnabled(true);

                try
                {
                    boolean wynik = get();
                    if (wynik)
                    {
                        view.etykietaStatusu.setText("Logowanie pomyślne!");
                    }
                    else
                    {
                        view.etykietaStatusu.setText("Błędny login lub hasło!");
                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        };

        worker.execute();
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() ->
        {
            GlownyView view = new GlownyView();
            UzytkownikModel model = new UzytkownikModel();
            new GlownyController(view, model);
            view.setVisible(true);
        });
    }
}
