package rentacar.server.service.provider;

import java.util.HashMap;
import java.util.Map;

import rentacar.server.persistence.dao.AdministratorDao;
import rentacar.server.persistence.dao.ClientDao;
import rentacar.server.persistence.dao.PdvDao;
import rentacar.server.persistence.dao.PriceListDao;
import rentacar.server.persistence.dao.PriceListItemDao;
import rentacar.server.persistence.dao.RentingDao;
import rentacar.server.persistence.dao.TypeOfVehicleDao;
import rentacar.server.persistence.dao.VehicleDao;
import rentacar.server.persistence.dao.impl.AdministratorDaoImpl;
import rentacar.server.persistence.dao.impl.ClientDaoImpl;
import rentacar.server.persistence.dao.impl.PdvDaoImpl;
import rentacar.server.persistence.dao.impl.PriceListDaoImpl;
import rentacar.server.persistence.dao.impl.PriceListItemDaoImpl;
import rentacar.server.persistence.dao.impl.RentingDaoImpl;
import rentacar.server.persistence.dao.impl.TypeOfVehicleDaoImpl;
import rentacar.server.persistence.dao.impl.VehicleDaoImpl;
import rentacar.server.service.AdministatorService;
import rentacar.server.service.ClientService;
import rentacar.server.service.PdvService;
import rentacar.server.service.PriceListItemService;
import rentacar.server.service.PriceListService;
import rentacar.server.service.RentingService;
import rentacar.server.service.TypeOfVehicleService;
import rentacar.server.service.VehicleService;
import rentacar.server.service.impl.AdministatorServiceImpl;
import rentacar.server.service.impl.ClientServiceImpl;
import rentacar.server.service.impl.PdvServiceImpl;
import rentacar.server.service.impl.PriceListItemServiceImpl;
import rentacar.server.service.impl.PriceListServiceImpl;
import rentacar.server.service.impl.RentingServiceImpl;
import rentacar.server.service.impl.TypeOfVehicleServiceImpl;
import rentacar.server.service.impl.VehicleServiceImpl;

public class ServiceProvider {
	
	@SuppressWarnings("rawtypes")
	private final Map<Class, Object> manager;

	// volatile keyword here makes sure that
	// the changes made in one thread are
	// immediately reflect in other thread
	private static volatile ServiceProvider serviceProvider;

	private ServiceProvider() {

		this.manager = new HashMap<>();

		registerDaos();
		registerServices();
	}

	// optimized thread safe singleton creation
	public static ServiceProvider getInstance() {
		ServiceProvider result = serviceProvider; // to reduce access of volatile field, performance boost
		if (result == null) {
			synchronized (ServiceProvider.class) {
				result = serviceProvider;
				if (result == null) {
					result = serviceProvider = new ServiceProvider();
				}
			}
		}
		return result;
	}

	public Object getRequiredService(@SuppressWarnings("rawtypes") Class interfaceClass) {

		if (manager.containsKey(interfaceClass)) {
			return manager.get(interfaceClass);
		} else {
			return null;
		}
	}

	private void registerDaos() {
		manager.put(AdministratorDao.class, new AdministratorDaoImpl());
		manager.put(ClientDao.class, new ClientDaoImpl());
		manager.put(PdvDao.class, new PdvDaoImpl());
		manager.put(PriceListDao.class, new PriceListDaoImpl());
		manager.put(PriceListItemDao.class, new PriceListItemDaoImpl());
		manager.put(RentingDao.class, new RentingDaoImpl());
		manager.put(TypeOfVehicleDao.class, new TypeOfVehicleDaoImpl());
		manager.put(VehicleDao.class, new VehicleDaoImpl());

	}

	private void registerServices() {
		manager.put(AdministatorService.class, new AdministatorServiceImpl((AdministratorDao) manager.get(AdministratorDao.class)));
		manager.put(ClientService.class, new ClientServiceImpl((ClientDao) manager.get(ClientDao.class)));
		manager.put(PdvService.class, new PdvServiceImpl((PdvDao) manager.get(PdvDao.class)));
		manager.put(PriceListService.class, new PriceListServiceImpl((PriceListDao) manager.get(PriceListDao.class)));
		manager.put(PriceListItemService.class, new PriceListItemServiceImpl((PriceListItemDao) manager.get(PriceListItemDao.class)));
		manager.put(RentingService.class, new RentingServiceImpl((RentingDao) manager.get(RentingDao.class)));
		manager.put(TypeOfVehicleService.class, new TypeOfVehicleServiceImpl((TypeOfVehicleDao) manager.get(TypeOfVehicleDao.class)));
		manager.put(VehicleService.class, new VehicleServiceImpl((VehicleDao) manager.get(VehicleDao.class)));
	}

}
