package homework.hw4.Core;

import homework.hw4.Interfaces.ICarrierRepo;
import homework.hw4.Interfaces.ICashRepo;
import homework.hw4.Models.Carrier;
import homework.hw4.Models.Ticket;
import homework.hw4.Models.User;
import homework.hw4.Services.CarrierRepository;
import homework.hw4.Services.CashRepository;

/**
 * Класс - провайдер для взаимодействия с банком и базой перевозчиков
 */
public class CashProvider {

    private long cardNumber;
    private boolean isAuthorized = false;
    private ICarrierRepo carrierRepository;
    private ICashRepo cashRepository;

    /**
     * Конструктор класса
     */
    public CashProvider() {
        // Класс репозитория находится в единственном экземпляре для того, чтобы не
        // создавать несколько подключений
        // к базе данных. Реализация паттерна Синглтон.
        this.carrierRepository = CarrierRepository.getCarrierRepository();
        this.cashRepository = CashRepository.getCashRepository();
    }

    /**
     * Метод покупки билета
     *
     * @param ticket билет
     * @return результат выполнения операции
     * @throws RuntimeException
     */
    public boolean buy(Ticket ticket) throws RuntimeException {
        if (isAuthorized) {
            Carrier carrier = carrierRepository.read(1);
            return cashRepository.transaction(ticket.getPrice(), cardNumber, carrier.getCardNumber());
        }
        return false;
    }
    // подсказка Carrier carrier = carrierRepository.read(1);
    // подсказка return cashRepository.transaction(ticket.getPrice(), cardNumber,
    // carrier.getCardNumber());

    /**
     * Метод авторизации клиента. Здесь должно быть реализовано обращение к банку
     * для подтверждения личности клиента.
     *
     * @param client
     */
    public void authorization(User client) {
        // Здесь должна быть реализована сверка аккаунта приложения и банковского
        // аккаунта.
        cardNumber = client.getCardNumber();
        isAuthorized = true;
    }

}
