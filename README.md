# **Human action transfer to 3d models in AR**

An AR Android app in which a human skeleton model will be projected and can be manipulated. It will be able to perform simple tasks, like walking, running, etc.

**Workflow for development of the project:**
![Screenshot 2022-02-09 230555](https://user-images.githubusercontent.com/64301737/153257664-f1c212f8-4335-4d97-8cb2-3e9596a923d6.png)

For the project, we have ***android studio*** as the software which manipulates the data for *AR app* to be executed. ***ARCore*** is software development kit by Google that assists in the building of AR applications in studio. ***Blender*** has been used for character modelling and providing required animation to the skeleton model.

**Steps used for the development of the project are:**
1. First, we have to set the environment for the development of the project. Sceneform is the plugin used for viewing, importing and building 3D assets.
2. Now, we work on to build our skeleton model. For that, we will be using the Blender interface. We can either import the model or build it from scratch. To build the skeleton model, use the concepts of character modelling.
3. Next, we will move on to give the necessary animations to our character model.
4. We then have to import the model (with animations) in the studio.
5. We have used *Java* to create and edit classes in the project. For the project, we have used two classes, namely MainActivity.java and ModelLoader.java. ModelLoader is used to load the model from the file and set renderable to it. A Renderable is a 3D model and consists of vertices, materials, textures, and more.

Final working of App Demo can be seen in following short video:


https://user-images.githubusercontent.com/64301737/153262364-314ede77-a8bf-4998-ae67-dd99b7b390c9.mp4



For more details of Project, please refer to the [document](https://drive.google.com/file/d/1TqeLK_097W4uU8u9IdUMd_uGbneI41ez/view?usp=sharing)
