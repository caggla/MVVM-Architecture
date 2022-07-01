# MVVMArchitecture


Model is POJO class which represents logic associated with application data. View means UI layout which informs ViewModel about user’s actions. ViewModel is behavior model of view which interacts with model to describe state of data.

LiveData is an observable data holder class. Unlike a regular observable, LiveData is lifecycle-aware, meaning it respects the lifecycle of other app components, such as activities, fragments, or services. This awareness ensures LiveData only updates app component observers that are in an active lifecycle state.

ViewModel is created to store and manage UI-related data in a lifecycle conscious way. It allows data to survive configuration changes such as screen rotations.


![image](https://user-images.githubusercontent.com/105305189/176798506-571ab89a-1755-431a-ad82-8094dcfdba5c.png)
