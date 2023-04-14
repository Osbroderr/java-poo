package com.example.banque.services;

@Service
public class InitData {

    @Autowired
    private ClientService clientService;

    @Autowired
    private CompteBancaireService compteBancaireService;

    @Autowired
    private CreditService creditService;

    @PostConstruct
    public void init() {
        // Création de clients
        Client client1 = new Client("Jean", "Dupont", "0123456789");
        clientService.saveClient(client1);

        Client client2 = new Client("Marie", "Martin", "0987654321");
        clientService.saveClient(client2);

        // Création de comptes bancaires
        CompteBancaire compte1 = new CompteBancaire("FR1234567890", client1);
        compteBancaireService.saveCompteBancaire(compte1);

        CompteBancaire compte2 = new CompteBancaire("FR0987654321", client2);
        compteBancaireService.saveCompteBancaire(compte2);

        // Création de crédits
        Credit credit1 = new Credit(compte1, 1000, 0.05, 12, 100);
        creditService.saveCredit(credit1);

        Credit credit2 = new Credit(compte2, 500, 0.10, 6, 75);
        creditService.saveCredit(credit2);
    }
}
