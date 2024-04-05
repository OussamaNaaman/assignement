package ma.emsi.assignementg62;

import ma.emsi.assignementg62.entities.*;
import ma.emsi.assignementg62.repository.*;
import ma.emsi.assignementg62.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class AssignementG62Application implements CommandLineRunner {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private MedecinRepository medecinRepository;

    @Autowired
    private RendezVousRepository rendezVousRepository;

    public static void main(String[] args) {
        SpringApplication.run(AssignementG62Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Patient patient1 = new Patient();
        patient1.setName("Hicham");
        patient1.setPhoneNumber("+212612345678");
        patient1.setAddress("Rabat, Maroc");
        patient1.setDateOfBirth(String.valueOf(new Date()));

        Patient patient2 = new Patient();
        patient2.setName("Fatima Zahra");
        patient2.setPhoneNumber("+212612345679");
        patient2.setAddress("Casablanca, Maroc");
        patient2.setDateOfBirth(String.valueOf(new Date()));

        patientRepository.save(patient1);
        patientRepository.save(patient2);

        List<Patient> patients = patientRepository.findAll();
        for (Patient patient : patients) {
            System.out.println(patient);
        }

        Medecin medecin1 = new Medecin();
        medecin1.setName("Dr. Ahmed");
        medecin1.setSpecialization("Cardiologue");
        medecin1.setPhoneNumber("+212987654321");

        Medecin medecin2 = new Medecin();
        medecin2.setName("Dr. Fatima");
        medecin2.setSpecialization("Pédiatre");
        medecin2.setPhoneNumber("+212987654322");

        medecinRepository.save(medecin1);
        medecinRepository.save(medecin2);

        List<Medecin> medecins = medecinRepository.findAll();
        for (Medecin medecin : medecins) {
            System.out.println(medecin);
        }

        RendezVous rendezVous = new RendezVous();
        rendezVous.setPatient(patient1);
        rendezVous.setMedecin(medecin1);
        rendezVous.setDate(new Date());

        rendezVousRepository.save(rendezVous);

        List<RendezVous> rendezVousList = rendezVousRepository.findAll();
        for (RendezVous rdv : rendezVousList) {
            System.out.println(rdv);
        }

        Optional<Patient> optionalPatient = patientRepository.findById(1L);
        optionalPatient.ifPresent(patient -> {
            patient.setName("Hicham updated");
            patientRepository.save(patient);
        });

        Optional<Medecin> optionalMedecin = medecinRepository.findById(1L);
        optionalMedecin.ifPresent(medecin -> {
            medecin.setName("Dr. Ahmed updated");
            medecinRepository.save(medecin);
        });
    }
}
