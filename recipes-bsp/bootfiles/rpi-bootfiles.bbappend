
SRC_URI += "https://files.waveshare.com/wiki/common/Waveshare35b-v2.zip;name=waveshare"
SRC_URI[waveshare.sha256sum] = "835cfb483e95375e7a5fb39250a5a40c7bb90d08349416760b78679c455890b4"

do_deploy:append() {
     install -m 0644 ${WORKDIR}/waveshare35b-v2.dtbo ${DEPLOYDIR}
}
