FILESEXTRAPATHS:prepend := "${THISDIR}/openssh:"

SRC_URI += " \
    file://sshdgenkeys.conf \
    file://10-sshconfigup.conf \
    file://20-hardening.conf \
    file://sigmastudio_admin.pub \
"

do_install:append() {
    install -d ${D}${systemd_system_unitdir}/sshdgenkeys.service.d/
    install -d ${D}${sysconfdir}/ssh/sshd_config.d/
    install -d ${D}${sysconfdir}/ssh/authorized_keys.d/
    install -m 0644 ${WORKDIR}/sshdgenkeys.conf    ${D}${systemd_system_unitdir}/sshdgenkeys.service.d/
    install -m 0644 ${WORKDIR}/10-sshconfigup.conf ${D}${sysconfdir}/ssh/sshd_config.d/
    install -m 0644 ${WORKDIR}/20-hardening.conf ${D}${sysconfdir}/ssh/sshd_config.d/
    install -m 0644 ${WORKDIR}/sigmastudio_admin.pub ${D}${sysconfdir}/ssh/authorized_keys.d/root
    sed -i '\|^HostKey /var/run/ssh|d' ${D}${sysconfdir}/ssh/sshd_config_readonly
}

FILES:${PN} += "\
   ${systemd_system_unitdir}/sshdgenkeys.service.d/sshdgenkeys.conf \
   ${sysconfdir}/ssh/sshd_config.d/10-sshconfigup.conf \
   ${sysconfdir}/ssh/sshd_config.d/20-hardening.conf \
   ${sysconfdir}/ssh/authorized_keys.d/root \
"