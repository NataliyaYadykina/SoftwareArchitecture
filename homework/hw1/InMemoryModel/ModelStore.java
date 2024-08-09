package homework.hw1.InMemoryModel;

import java.util.ArrayList;

import homework.hw1.ModelElements.*;

public class ModelStore implements IModelChangeObserver, IModelChanger {

    public ArrayList<PoligonalModel> Models = new ArrayList<PoligonalModel>();
    public ArrayList<Scene> Scenes = new ArrayList<Scene>();
    public ArrayList<Flash> Flashes = new ArrayList<Flash>();
    public ArrayList<Camera> Cameras = new ArrayList<Camera>();

    public Scene getScene(int n_scene) {

        return Scenes.get(n_scene);
    }

    @Override
    public void NotifyChange() {

    }

    @Override
    public void ApplyUpdateModel() {

    }
}
