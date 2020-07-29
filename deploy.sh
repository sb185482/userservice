docker build --tag userservice:1.0 .
docker tag userservice:1.0 gcr.io/datanauts/userservice:1.0
gcloud auth login
docker push gcr.io/datanauts/userservice:1.0
gcloud container clusters get-credentials cluster-1 --zone us-central1-c --project datanauts
kubectl apply -f ./userservice.yaml

kubectl get services