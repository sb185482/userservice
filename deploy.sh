docker build --tag userservice .
docker tag userservice gcr.io/datanauts/userservice
docker push gcr.io/datanauts/userservice
gcloud container clusters get-credentials cluster-1 --zone us-central1-c --project datanauts
kubectl apply -f ./userservice.yaml